package org.chronicweirdo.dump.model;

import java.io.File;
import java.util.*;

/**
 * Files that have the same date and title form a post.
 * All file tags are aggregated to post tags.
 * Each file in a post can have its own index and caption.
 * Created by scacoveanu on 12/29/2014.
 */
public class Post {

    // common data
    private String title;
    private Date creationDate;
    private Set<String> tags = new HashSet<String>();

    public String getTitle() {
        return title;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void addTags(Set<String> tags) {
        this.tags.addAll(tags);
    }

    private List<File> files = new ArrayList<File>();
    private List<String> indexes = new ArrayList<String>();
    private List<String> captions = new ArrayList<String>();

    public void addFile(File root, String caption, String index) {
        files.add(root);
        captions.add(caption);
        indexes.add(index);
    }
}
