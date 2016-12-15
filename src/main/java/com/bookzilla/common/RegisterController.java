package com.bookzilla.common;

import com.bookzilla.model.User;
import com.bookzilla.security.SecurityConfiguration;
import com.bookzilla.security.SecurityService;
import com.bookzilla.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by adinu on 12/4/16.
 */
@Controller
public class RegisterController {

    private static final Logger logger = Logger.getLogger(RegisterController.class);

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam String lastName,
                           @RequestParam String firstName,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String passwordConf,
                           @RequestParam String emailAddress,
                           HttpServletRequest request) {

        logger.debug("Proceed with request of adding a new user");

        User.SEQUENCE_NUM = userService.getNextSequenceNum() - 1;
        User user = new User(0, firstName, lastName, username, password, emailAddress, null);

        try {
            userService.addUser(user);

            securityService.autoLogin(username, password);

        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/library";
    }
}
