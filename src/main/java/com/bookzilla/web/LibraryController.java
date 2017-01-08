package com.bookzilla.web;

import com.bookzilla.service.BookService;
import com.bookzilla.model.Book;
import com.bookzilla.model.User;
import com.bookzilla.service.SecurityService;
import com.bookzilla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adinu on 12/3/16.
 */
@Controller
@RequestMapping(value = "/library")
public class LibraryController {

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showHomepage() {

        ModelAndView mv = new ModelAndView("library");

        String username = securityService.findLoggedInUserName();
        User user = userService.findByUsername(username);

        mv.addObject("firstname", user.getFirstName());
        mv.addObject("lastname", user.getLastName());
        mv.addObject("username", username);

        List<Book> allBooks = bookService.retrieveAllBooks();

        mv.addObject("allBooks", allBooks);
        mv.addObject("matchedBooks", new ArrayList<Book>());

        return mv;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView searchBooks(
            @RequestParam(value = "search_key", required = true) String search_key) {

        ModelAndView mv = new ModelAndView("library");

        String username = securityService.findLoggedInUserName();
        User user = userService.findByUsername(username);

        mv.addObject("firstname", user.getFirstName());
        mv.addObject("lastname", user.getLastName());
        mv.addObject("username", username);

        String search_key_lowercase = search_key.toLowerCase();
        List<Book> allBooks = bookService.retrieveAllBooks();
        List<Book> matchedBooks = new ArrayList<>();
        String[] searchTokens = search_key_lowercase.split(" ");
        boolean isAMatch = true;
        boolean matchedToken;
        for (Book book : allBooks) {

            isAMatch = true;

            /* search in the books titles */
            String bookTitle = book.getTitle().toLowerCase();
            String[] titleTokens = bookTitle.split(" ");

            String bookAuthor = book.getAuthor().toLowerCase();
            String[] authorTokens = bookAuthor.split(" ");

            /* match brut pt tokeni */
            for (String searchToken : searchTokens) {
                matchedToken = false;
                for (String titleToken : titleTokens) {
                    if (titleToken.compareTo(searchToken) == 0) {
                        matchedToken = true;
                        break;
                    }
                }

                if (!matchedToken) {
                    isAMatch = false;
                    break;
                }
            }

            if (isAMatch) {
                matchedBooks.add(book);
            } else {
                isAMatch = true;
                /* try to match the author in the same way */
                for (String searchToken : searchTokens) {
                    matchedToken = false;
                    for (String authorToken : authorTokens) {
                        if (authorToken.compareTo(searchToken) == 0) {
                            matchedToken = true;
                            break;
                        }
                    }

                    if (!matchedToken) {
                        isAMatch = false;
                        break;
                    }
                }

                if (isAMatch) {
                    matchedBooks.add(book);
                }
            }
        }

        mv.addObject("allBooks", new ArrayList<Book>());
        mv.addObject("matchedBooks", matchedBooks);

        return mv;
    }

}
