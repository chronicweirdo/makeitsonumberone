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

    private TreeMap<String, Section> sections = new TreeMap<String, Section>();

    public void addFile(File root, String caption, String index) {
        Section section = new Section();
        section.setCaption(caption);
        section.setFile(root);
        section.setIndex(index);
        sections.put(index, section);
    }

    public Collection<Section> getSections() {
        return sections.values();
    }
}
