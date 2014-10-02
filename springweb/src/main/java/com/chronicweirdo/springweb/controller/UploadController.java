package com.chronicweirdo.springweb.controller;

import com.chronicweirdo.springweb.command.UploadCommand;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * Created by scacoveanu on 6/23/2014.
 */
@Controller
@RequestMapping(value = "/upload", method = RequestMethod.POST)
public class UploadController extends AbstractCommandController {

    private static final Logger log = Logger.getLogger(UploadController.class);

    public UploadController() {
        setCommandClass(UploadCommand.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object command, BindException e) throws Exception {
        UploadCommand uploadCommand = (UploadCommand) command;

        log.info("command file name: " + uploadCommand.getFileName());
        log.info("command file type: " + uploadCommand.getType());

        MultipartFile file = uploadCommand.getFile();
        log.info("content type: " + file.getContentType());
        log.info("original name: " + file.getOriginalFilename());
        String extension = getExtension(file.getOriginalFilename());
        log.info("extension: " + extension);
        log.info("command file: " + file);
        String targetName = getServletContext().getRealPath("/") + uploadCommand.getFileName();
        if (extension != null) {
            targetName += '.' + extension;
        }
        File target = new File(targetName);
        System.out.println(target.getAbsolutePath());
        target.createNewFile();

        file.transferTo(target);

        return new ModelAndView("upload");
    }

    private String getExtension(String originalFilename) {
        int position = originalFilename.lastIndexOf('.');
        if (position == -1) {
            return null;
        }
        return originalFilename.substring(position + 1);
    }


}
