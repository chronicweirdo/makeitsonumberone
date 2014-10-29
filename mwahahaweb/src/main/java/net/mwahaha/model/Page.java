package net.mwahaha.model;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/29/2014.
 */
public class Page {

    private String title;

    private String type;

    private List<Tag> tags = new ArrayList<>();

    private Path path;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
