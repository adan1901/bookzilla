package com.bookzilla.user;

import com.bookzilla.book.BookService;
import com.bookzilla.model.Book;
import com.bookzilla.model.User;
import com.bookzilla.security.SecurityService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by adinu on 12/5/16.
 */
@Controller
@RequestMapping(value = "/user-details")
public class UserDetailsController {

    private final static Logger logger = Logger.getLogger(UserDetailsController.class);

    @Autowired
    UserService userService;

    @Autowired
    BookService bookService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/show-profile", method = RequestMethod.GET)
    public ModelAndView showUserDetails(@RequestParam(value = "username", required = false) String username) {

        ModelAndView mv = new ModelAndView("profile_details");

        String loggedInUserName = securityService.findLoggedInUserName();
        User loggedInUser = userService.findUserByUsername(loggedInUserName);

        boolean userIsPriviliged = true;

        User user = loggedInUser;
        if (username != null) {
            user = userService.findUserByUsername(username);

            if (!user.equals(loggedInUser)) {
                userIsPriviliged = false;
            } else {

            }
        }

        mv.addObject("userIsPriviliged", userIsPriviliged);

        logger.debug("Retrieving books for user " + user);

        /* Add user details */
        mv.addObject("firstName", user.getFirstName());
        mv.addObject("lastName", user.getLastName());

        /* Retrieve all books owned by current user */
        List<Book> ownedBooks = bookService.retrieveBooksFromUserLibrary(user.getId());
        for (Book book : ownedBooks) {
            logger.debug("Retrieving book " + book);
        }
        mv.addObject("bookCollection", ownedBooks);

        return mv;
    }

}
