package org.chronicweirdo.dump.model;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class Post {

    private Date creationDate;
    private Date lastModifiedDate;

    private List<String> tags;
    private List<File> files;

    private String title;

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
