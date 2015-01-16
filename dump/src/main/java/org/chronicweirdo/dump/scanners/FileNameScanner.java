package org.chronicweirdo.dump.scanners;

import org.chronicweirdo.dump.Util;
import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.FormattingException;
import org.chronicweirdo.dump.service.Tag;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Created by Silviu on 1/2/2015.
 */
public class FileNameScanner implements Scanner {

    @Override
    public Post scan(File file) {
        if (FileNameParser.accept(file)) {
            try {
                Map<String, Set<String>> tags = FileNameParser.parse(file);
                Post post = new Post();
                post.setTitle(getTitle(file, tags));
                post.setCreationDate(getCreationDate(file, tags));
                post.addTags(tags.get(Tag.TAG.n()));
                post.addFile(file,
                        getSingleField(tags, Tag.CAPTION.n(), file.getPath().toString(), ""),
                        getSingleField(tags, Tag.INDEX.n(), file.getPath().toString(), ""),
                        getProcessor(file, tags));
                return post;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private String getProcessor(File file, Map<String, Set<String>> tags) {
        return getSingleField(tags, Tag.PROCESSOR.n(), file.getPath(), getExtension(file));
    }

    private String getExtension(File file) {
        return file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();
    }

    private String getTitle(File file, Map<String, Set<String>> tags) throws FormattingException {
        return getSingleField(tags, Tag.TITLE.n(), file.getAbsolutePath());
    }

    private Date getCreationDate(File file, Map<String, Set<String>> tags) throws FormattingException, NumberFormatException {
        return Util.getDate(tags.get(Tag.CREATED.n()).iterator().next());
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

    private String getSingleField(Map<String, Set<String>> tags, String name, String itemId, String def) {
        try {
            return getSingleField(tags, name, itemId);
        } catch (FormattingException e) {
            // allowed
        }
        return def;
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
}
