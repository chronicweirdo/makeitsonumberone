package org.chronicweirdo.dump.model;

import org.chronicweirdo.dump.service.FileNameParser;

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

    public Set<String> getTags() {
        return tags;
    }

    private TreeMap<String, Section> sections = new TreeMap<String, Section>();

    public void addFile(File root, String caption, String index, String processor) {
        Section section = new Section();
        section.setCaption(caption);
        section.setFile(root);
        section.setIndex(index);
        section.setProcessor(processor);
        sections.put(index, section);
    }

    public Collection<Section> getSections() {
        return sections.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (!creationDate.equals(post.creationDate)) return false;
        if (!title.equals(post.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }

    public void merge(Post filePost) {
        this.addTags(filePost.getTags());
        this.sections.putAll(filePost.sections);
    }
}
