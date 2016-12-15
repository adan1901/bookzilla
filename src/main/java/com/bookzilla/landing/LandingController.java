package com.bookzilla.landing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by adinu on 12/14/16.
 */
@Controller
public class LandingController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLandingPage() {

        return "landing";
    }
}
