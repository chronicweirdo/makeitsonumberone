package com.chronicweirdo.springweb.command;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by scacoveanu on 6/23/2014.
 */
public class UploadCommand {

    private String fileName;

    private String type;

    private MultipartFile file;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
