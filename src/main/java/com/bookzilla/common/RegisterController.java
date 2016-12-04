package com.bookzilla.common;

import com.bookzilla.model.User;
import com.bookzilla.security.SecurityService;
import com.bookzilla.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adinu on 12/4/16.
 */
@Controller
public class RegisterController {

    private Logger logger = Logger.getLogger("RegisterController");

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {

        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String lastName,
                           @RequestParam String firstName,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String passwordConf,
                           @RequestParam String emailAddress) {

        logger.debug("Proceed with request of adding a new user");

        User user = new User(0, firstName, lastName, username, password, emailAddress, null);

        try {
            userService.addUser(user);
        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/login";
    }
}
