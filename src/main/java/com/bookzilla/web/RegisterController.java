package com.bookzilla.web;

import com.bookzilla.model.User;
import com.bookzilla.service.SecurityService;
import com.bookzilla.service.UserService;
import com.bookzilla.validator.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("userForm", new User());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "register";
        }

        logger.debug("Proceed with request of adding a new user");

        try {

            userForm.setLocation("Bucuresti");
            userService.addUser(userForm);

            securityService.autoLogin(userForm.getUsername(), userForm.getPassword());

        } catch (Exception e) {
            logger.error(e);
        }

        return "redirect:/library";
    }
}
