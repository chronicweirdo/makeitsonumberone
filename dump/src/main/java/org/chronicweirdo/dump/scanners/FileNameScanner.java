package org.chronicweirdo.dump.scanners;

import org.chronicweirdo.dump.model.Post;
import org.chronicweirdo.dump.service.FileNameParser;
import org.chronicweirdo.dump.service.FormattingException;

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
        try {
            Map<String, Set<String>> tags = FileNameParser.parse(file);
            Post post = new Post();
            post.setTitle(getTitle(file, tags));
            post.setCreationDate(getCreationDate(file, tags));
            post.addTags(tags.get(FileNameParser.TAG));
            post.addFile(file,
                    getSingleField(tags, FileNameParser.CAPTION, file.getPath().toString(), ""),
                    getSingleField(tags, FileNameParser.INDEX, file.getPath().toString(), ""),
                    getProcessor(file, tags));
            return post;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getProcessor(File file, Map<String, Set<String>> tags) {
        return getSingleField(tags, FileNameParser.PROCESSOR, file.getPath(), getExtension(file));
    }

    private String getExtension(File file) {
        return file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();
    }

    private String getTitle(File file, Map<String, Set<String>> tags) throws FormattingException {
        return getSingleField(tags, FileNameParser.TITLE, file.getAbsolutePath());
    }

    private Date getCreationDate(File file, Map<String, Set<String>> tags) throws FormattingException, NumberFormatException {
        Calendar created = null;
        try {
            BasicFileAttributes attr = Files.readAttributes(Paths.get(file.toURI()), BasicFileAttributes.class);
            created = Calendar.getInstance();
            created.setTimeInMillis(attr.creationTime().toMillis());
        } catch (IOException e) {
            // allowed to not have a date on filesystem
        }
        Calendar calendar = Calendar.getInstance();
        setCalendarField(calendar, Calendar.YEAR, tags, FileNameParser.YEAR, file.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.MONTH, tags, FileNameParser.MONTH, file.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.DAY_OF_MONTH, tags, FileNameParser.DAY, file.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.HOUR_OF_DAY, tags, FileNameParser.HOUR, file.getAbsolutePath(), created);
        setCalendarField(calendar, Calendar.MINUTE, tags, FileNameParser.MINUTE, file.getAbsolutePath(), created);
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
