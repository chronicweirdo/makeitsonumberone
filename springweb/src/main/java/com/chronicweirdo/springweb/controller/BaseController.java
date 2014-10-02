package com.chronicweirdo.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by scacoveanu on 6/23/2014.
 */
@Controller
@RequestMapping("/")
public class BaseController {

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcome(ModelMap model) {
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - welcome()");
        return "index";
    }

    @RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap model) {
        model.addAttribute("message", "Maven Web Project + Spring 3 MVC - " + name);
        return "index";
    }

    @RequestMapping(value = "/doupload", method = RequestMethod.GET)
    public String uploadPage() {
        return "doupload";
    }
}
