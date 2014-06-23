package com.chronicweirdo.springweb.controller;

import com.chronicweirdo.springweb.command.APICommand;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by scacoveanu on 6/23/2014.
 */
@Controller
@RequestMapping("/api")
public class APIController extends AbstractCommandController {

    private static final Logger log = Logger.getLogger(APIController.class);

    public APIController() {
        setCommandClass(APICommand.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object command, BindException e) throws Exception {
        APICommand apiCommand = (APICommand) command;
        log.info("command method name: " + apiCommand.getMethodName());
        if (apiCommand.getGeneId() != null) {
            log.info("gene ids size: " + apiCommand.getGeneId().length);
        } else {
            log.info("gene ids are null");
        }

        return new ModelAndView("api");
    }
}
