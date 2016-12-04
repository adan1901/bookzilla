package com.bookzilla.homepage;

import com.bookzilla.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adinu on 12/3/16.
 */
@Controller
public class HomepageController {

    @Autowired
    SecurityService securityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showHomepage() {

        ModelAndView mv = new ModelAndView("homepage");
        mv.addObject("name", securityService.findLoggedInUserName());

        return mv;
    }
}
