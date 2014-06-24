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
import java.io.BufferedReader;
import java.io.IOException;


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
        logRequest(request);
        return new ModelAndView("api");
    }

    private void logRequest(HttpServletRequest request) {
        try {
            log.info(">>>>>>> request is null: " + (request == null));
            log.info(">>>>>>> request object class: " + request.getClass().getName());
            log.info(">>>>>>> request content lenght: " + request.getContentLength());
            String[] parameterValues = request.getParameterValues("geneId");
            if (parameterValues == null) {
                log.info(">>>>> gene id parameter values on request are null");
            } else {
                log.info(">>>>>>> gene id parameter values on request size: " + parameterValues.length);
            }
            StringBuilder builder = new StringBuilder();
            String line;
            BufferedReader reader = null;

            reader = request.getReader();

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            log.info(">>>>>>>>> request builder length: " + builder.length());
            if (builder.length() > 200) {
                log.info(">>>>>>>> request end: " + builder.substring(builder.length() - 200));
            } else {
                log.info(">>>>>>>> request: " + builder.toString());
            }
        } catch (IOException e) {
            log.error(e, e);
            log.info(">>>>>>>>> error: " + e.getMessage());
        }
    }
}
