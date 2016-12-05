package com.bookzilla.user;

import com.bookzilla.model.User;
import com.bookzilla.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adinu on 12/5/16.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/user-details", method = RequestMethod.GET)
    public ModelAndView showUserDetails() {

        ModelAndView mv = new ModelAndView("profile_details");

        String username = securityService.findLoggedInUserName();
        User user = userService.findUserByUsername(username);

        mv.addObject("firstName", user.getFirstName());
        mv.addObject("lastName", user.getLastName());

        return mv;
    }


}
