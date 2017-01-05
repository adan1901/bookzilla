package com.bookzilla.book;

import com.bookzilla.model.Book;
import com.bookzilla.model.Category;
import com.bookzilla.model.User;
import com.bookzilla.security.SecurityService;
import com.bookzilla.service.CategoryService;
import com.bookzilla.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Controller
public class BookController {

    private static final Logger logger = Logger.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/add-book", method = RequestMethod.GET)
    public String addBook() {

        return "add_book";
    }

    @RequestMapping(value = "/add-book", method = RequestMethod.POST)
    public String addBook(@RequestParam String bookTitle,
                          @RequestParam String bookCoverUrl,
                          @RequestParam String bookAuthor,
                          @RequestParam String bookPublisher,
                          @RequestParam String bookLanguage,
                          @RequestParam String bookCateg) {

        logger.debug("Proceed with request of adding a new book");

        String username = securityService.findLoggedInUserName();
        User currentUser = userService.findUserByUsername(username);

        Book book = new Book();
        book.setTitle(bookTitle);
        book.setUrl(bookCoverUrl);
        book.setAuthor(bookAuthor);
        book.setPublisher(bookPublisher);
        book.setLanguage(bookLanguage);
        book.setOwnerUser(currentUser);
        logger.debug("Created book with following details: " + book);

        // modify this to use a collection of categories
        Category category = new Category();
        category.setName(bookCateg);
        category.setBook(book);

        try {

            bookService.registerBook(book);

            categoryService.registerCategory(category);
        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/library";
    }

    @RequestMapping(value = "/book-details/{bookId}", method = RequestMethod.GET)
    public ModelAndView showBookDetails(@PathVariable String bookId) {

        ModelAndView mv = new ModelAndView("book_details");

        /* Take current user details */
        String username = securityService.findLoggedInUserName();
        User currentUser = userService.findUserByUsername(username);

        mv.addObject("firstName", currentUser.getFirstName());
        mv.addObject("lastName", currentUser.getLastName());

        /* Take current book details */
        Book userBook = bookService.findBookById(Long.parseLong(bookId));

        if (userBook != null) {
            mv.addObject("bookTitle", userBook.getTitle());
            mv.addObject("bookAuthor", userBook.getAuthor());
            mv.addObject("bookPublisher", userBook.getPublisher());
            mv.addObject("bookCategory", userBook.getCategories());
            mv.addObject("bookImgUrl", userBook.getUrl());

            /* Try to see who is having this book */
            List<User> usersHavingTheBook = new ArrayList<>();
            List<User> allRegisteredUsers = userService.listAllUsers();

            for (User otherUser : allRegisteredUsers) {

                List<Book> otherUserBooks = bookService.retrieveBooksFromUserLibrary(otherUser);

                if ((otherUserBooks != null) && (otherUserBooks.size() > 0)) {
                    for (Book otherUserBook : otherUserBooks) {
                        if (userBook.getTitle().toLowerCase()
                                .compareTo(otherUserBook.getTitle().toLowerCase()) == 0) {
                            usersHavingTheBook.add(otherUser);
                        }
                    }
                }
            }

            mv.addObject("usersHavingTheBook", usersHavingTheBook);
        }

        return mv;
    }
}
