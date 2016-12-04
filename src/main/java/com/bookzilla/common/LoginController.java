package com.bookzilla.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

        return mv;
    }
}

