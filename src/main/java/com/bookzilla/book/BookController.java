package com.bookzilla.book;

import com.bookzilla.model.Book;
import com.bookzilla.model.User;
import com.bookzilla.security.SecurityService;
import com.bookzilla.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        User user = userService.findUserByUsername(username);

        Book book = new Book(bookCateg, "Bucuresti", bookAuthor, bookPublisher, bookTitle,
                bookLanguage, user.getId(), -1, bookCoverUrl, "no description", 0);

        try {
            bookService.registerBook(book);
        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/homepage";
    }

    @RequestMapping(value = "/book-details/{id}", method = RequestMethod.GET)
    public ModelAndView showBookDetails() {

        ModelAndView mv = new ModelAndView("book");
        mv.addObject("name", securityService.findLoggedInUserName());

        return mv;
    }
}
