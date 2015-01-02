package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.model.Post;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Service that scans a folder and returns a list of posts.
 *
 * Created by scacoveanu on 12/29/2014.
 */
public class ScannerService {

    private FileNameParser fileNameParser;

    public void setFileNameParser(FileNameParser fileNameParser) {
        this.fileNameParser = fileNameParser;
    }

    public List<Post> scan(File root) {
        List<Post> posts = new ArrayList<Post>();
        try {
            scan(root, posts);
        } catch (FormattingException e) {
            System.out.println(e);
        }
        return posts;
    }

    private void scan(File root, List<Post> posts) throws FormattingException {
        if (root.isFile()) {
            Map<String, Set<String>> tags = fileNameParser.parse(root.getName());
            String title = getTitle(root, tags);
            Date creationDate = getCreationDate(root, tags);
            Post post = findPost(posts, title, creationDate);
            if (post == null) {
                post = createPost(title, creationDate);
                posts.add(post);
            }
            addFile(post, root, tags);
        } else {
            for (File child : root.listFiles()) {
                try {
                    scan(child, posts);
                } catch (FormattingException e) {
                    System.out.println(e);
                }
            }
        }
    }

    private Date getCreationDate(File root, Map<String, Set<String>> tags) throws FormattingException, NumberFormatException {
        Calendar created = null;
        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get(root.toURI()), BasicFileAttributes.class);
            created = Calendar.getInstance();
            created.setTimeInMillis(attr.creationTime().toMillis());
        } catch (IOException e) {
            // allowed to not have a date on filesystem
        }
        Calendar calendar = Calendar.getInstance();
        // calendar.set(Calendar.YEAR, Integer.parseInt(getSingleField(tags, Parser.YEAR, root.getAbsolutePath())));
        //calendar.set(Calendar.MONTH, Integer.parseInt(getSingleField(tags, Parser.MONTH, root.getAbsolutePath())));
        setCalendarField(calendar, Calendar.YEAR, tags, FileNameParser.YEAR, root.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.MONTH, tags, FileNameParser.MONTH, root.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.DAY_OF_MONTH, tags, FileNameParser.DAY, root.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.HOUR_OF_DAY, tags, FileNameParser.HOUR, root.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.MINUTE, tags, FileNameParser.MINUTE, root.getAbsolutePath(), created);
        //calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(getSingleField(tags, Parser.DAY, root.getAbsolutePath())) - 1);
        //calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(getSingleField(tags, Parser.HOUR, root.getAbsolutePath())));
        //calendar.set(Calendar.MINUTE, Integer.parseInt(getSingleField(tags, Parser.HOUR, root.getAbsolutePath())));
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private void setCalendarField(Calendar calendar, int calendarField,
                             Map<String, Set<String>> tags, String fieldName, String itemId,
                             Calendar backup) throws FormattingException {
        // try to set field from tags
        Integer value = null;
        try {
            String string = getSingleField(tags, fieldName, itemId);
            value = Integer.parseInt(string);
            if (calendarField == Calendar.MONTH) {
                value -= 1;
            }
        } catch (FormattingException e) {
            // allowed
        } catch (NumberFormatException e) {
            // allowed
        }
        if (value != null) {
            calendar.set(calendarField, value);
        } else {
            // try to set field from file date
            if (backup != null) {
                calendar.set(calendarField, backup.get(calendarField));
            } else {
                throw new FormattingException("Can't get field " + fieldName + " for " + itemId);
            }
        }
    }

    private String getSingleField(Map<String, Set<String>> tags, String name, String itemId) throws FormattingException {
        if (tags.get(name) == null || tags.get(name).size() == 0) {
            throw new FormattingException("No " + name + " found for " + itemId);
        }
        if (tags.get(name).size() > 1) {
            throw new FormattingException("More than one " + name + " found for " + itemId);
        }
        return tags.get(name).iterator().next();
    }

    private String getTitle(File root, Map<String, Set<String>> tags) throws FormattingException {
        return getSingleField(tags, FileNameParser.TITLE, root.getAbsolutePath());
    }

    private void addFile(Post post, File root, Map<String, Set<String>> tags) throws FormattingException {
        // get tags and add them to post
        post.addTags(tags.get(FileNameParser.TAG));
        // add file to post
        String caption = "";
        try {
            caption = getSingleField(tags, FileNameParser.CAPTION, root.getAbsolutePath());
        } catch (FormattingException e) {
            // no caption is allowed
        }
        String index = "";
        try {
            index = getSingleField(tags, FileNameParser.INDEX, root.getAbsolutePath());
        } catch (FormattingException e) {
            // no index is allowed
        }
        post.addFile(root, caption, index);
    }

    private Post createPost(String title, Date creationDate) {
        Post post = new Post();
        post.setTitle(title);
        post.setCreationDate(creationDate);
        return post;
    }

    private Post findPost(List<Post> posts, String title, Date creationDate) {
        for (Post post: posts) {
            if (post.getTitle().equals(title) && post.getCreationDate().equals(creationDate)) {
                return post;
            }
        }
        return null;
    }


}
