package com.bookzilla.common;

import com.bookzilla.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.bookzilla.user.UserServiceImpl;
import com.bookzilla.dao.*;
import com.bookzilla.model.*;
import com.bookzilla.book.*;

import java.util.List;

/**
 * Created by adinu on 12/3/16.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView mv = new ModelAndView("login");

        if (error != null) {
            mv.addObject("error", "Invalid username and password");
        }

        if (logout != null) {
            mv.addObject("msg", "You've been logged out successfully.");
        }

        /*
        used for testing
        UserServiceImpl userserviceimpl = new UserServiceImpl();
        List<User> listautilizatori = userserviceimpl.listAllUsers();
        System.out.println(listautilizatori);
        BookDao bookdao = new BookDao();
        bookdao.saveObject(new Book(1, "category", "location", "author", "publisher","title", "language", 12, 123));
        BookServiceImpl bookserviceimpl = new BookServiceImpl();
        System.out.println(bookserviceimpl.findBooks(null,null, null, null, null, null, null ,null, null, null ));

        */
        return mv;
    }
}

