package org.chronicweirdo.dump.service;

import org.chronicweirdo.dump.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Service that will take the file name and extract all available tags from it.
 * Tag syntax is [tag.value].
 * Created by scacoveanu on 12/29/2014.
 */
public class FileNameParser {

    public static final String TAG_CLOSE = "]";
    public static final String TAG_OPEN = "[";
    public static final String ACCEPT_PATTERN = ".*\\[.*\\].*";


    // accepted tags and synonyms
    private static Map<String, String> formal;
    private static Map<String, String> copy;



    public static final String DEFAULT_TAG_NAME = Tag.TAG.n();

    static {
        formal = new HashMap<String, String>();
        formal.putAll(Util.map(
                Tag.EXTENSION.n(), Tag.EXTENSION.n(),
                Tag.CREATED.n(), Tag.CREATED.n(),
                Tag.MODIFIED.n(), Tag.MODIFIED.n(),
                Tag.FILE_CREATED.n(), Tag.FILE_CREATED.n(),
                Tag.FILE_MODIFIED.n(), Tag.FILE_MODIFIED.n(),
                Tag.TAG.n(), Tag.TAG.n(),
                Tag.INDEX.n(), Tag.INDEX.n(),
                "i", Tag.INDEX.n(),
                Tag.CAPTION.n(), Tag.CAPTION.n(),
                "c", Tag.CAPTION.n(),
                Tag.TITLE.n(), Tag.TITLE.n(),
                Tag.PROCESSOR.n(), Tag.PROCESSOR.n(),
                "p", Tag.PROCESSOR.n()
        ));

        copy = new HashMap<String, String>();
        copy.putAll(Util.map(
                Tag.EXTENSION.n(), Tag.PROCESSOR.n(),
                Tag.FILE_CREATED.n(), Tag.CREATED.n(),
                Tag.FILE_MODIFIED.n(), Tag.MODIFIED.n()
        ));
    }

    public static Map<String, Set<String>> parse(File file) {
        String fileName = file.getName();

        // process
        Map<String, Set<String>> processResult = new HashMap<>();
        processResult.putAll(processFileName(fileName));
        processResult.putAll(processFileAttributes(file));

        // post processFileName
        Map<String, Set<String>> postProcessResult = postProcess(processResult);
        return postProcessResult;
    }

    private static Map<String, Set<String>> processFileAttributes(File file) {
        Map<String, Set<String>> result = new HashMap<>();
        new FileAttributesProcessor(file).add(result);
        return result;
    }

    private static Map<String, Set<String>> postProcess(Map<String, Set<String>> processResult) {
        Map<String, Set<String>> result = new HashMap<>();
        // replace some shortcut tag names with formal names
        for (Map.Entry<String, Set<String>> entry: processResult.entrySet()) {
            String formalName = formal.get(entry.getKey());
            if (formalName != null) {
                result.put(formalName, entry.getValue());
            }
        }
        // copy some tags unde other tags (ex: extension to processor if processor does not exist)
        for (Map.Entry<String, String> entry: copy.entrySet()) {
            if (! result.containsKey(entry.getValue())) {
                result.put(entry.getValue(), result.get(entry.getKey()));
            }
        }
        return result;
    }

    public static boolean accept(File file) {
        return file.getName().matches(ACCEPT_PATTERN);
    }

    private static String[] splitStringKeepSpaces(String line) {
        String delimiterRegex = "([\\" + TAG_OPEN + "\\" + TAG_CLOSE + "])";
        String splitRegex = getSplitRegex(delimiterRegex);
        return line.split(splitRegex);
    }

    private static class TagProcessor {
        private String name;
        private String value;

        private TagProcessor(String text) {
            int dot = text.indexOf('.');
            if (dot == -1) {
                name = DEFAULT_TAG_NAME;
                value = text;
            } else {
                name = text.substring(0, dot);
                value = text.substring(dot+1);
            }
        }

        private void add(Map<String, Set<String>> map) {
            addToMap(map, name, value);
        }
    }

    private static void addToMap(Map<String, Set<String>> map, String name, String value) {
        if (! map.containsKey(name)) {
            map.put(name, new HashSet<String>());
        }
        map.get(name).add(value);
    }

    private static class FileAttributesProcessor {
        private String created;
        private String modified;

        private FileAttributesProcessor(File file) {
            Calendar dateCreated = null;
            Calendar dateModified = null;
            try {
                BasicFileAttributes attributes = Files.readAttributes(Paths.get(file.toURI()), BasicFileAttributes.class);
                dateCreated = Calendar.getInstance();
                dateCreated.setTimeInMillis(attributes.creationTime().toMillis());
                dateModified = Calendar.getInstance();
                dateModified.setTimeInMillis(attributes.lastModifiedTime().toMillis());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (dateCreated != null) {
                created = Util.getString(dateCreated);
            }
            if (dateModified != null) {
                modified = Util.getString(dateModified);
            }
        }

        private void add(Map<String, Set<String>> map) {
            if (created != null) {
                addToMap(map, Tag.FILE_CREATED.n(), created);
            }
            if (modified != null) {
                addToMap(map, Tag.FILE_MODIFIED.n(), modified);
            }
        }
    }

    private static class TitleProcessor {
        private String title;
        private String extension;

        private TitleProcessor(String text) {
            int dot = text.lastIndexOf('.');
            if (dot == -1) {
                title = text;
            } else {
                title = text.substring(0, dot);
                extension = text.substring(dot+1);
            }
        }

        private void add(Map<String, Set<String>> map) {
            addToMap(map, Tag.TITLE.n(), title.trim());
            if (extension != null) {
                addToMap(map, Tag.EXTENSION.n(), extension.trim().toLowerCase());
            }
        }
    }

    private static Map<String, Set<String>> processFileName(String fileName) {
        String[] tokens = splitStringKeepSpaces(fileName);

        boolean tag = false;
        Map<String, Set<String>> result = new HashMap<>();
        StringBuilder outside = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (String token : tokens) {
            if (tag) {
                if (TAG_CLOSE.equals(token)) {
                    tag = false;
                    new TagProcessor(current.toString()).add(result);
                    current = new StringBuilder();
                } else if (TAG_OPEN.equals(token)) {
                    // invalid, but ignore
                } else {
                    current.append(token);
                }
            } else {
                if (TAG_OPEN.equals(token)) {
                    tag = true;
                    outside.append(current.toString());
                    current = new StringBuilder();
                } else if (TAG_CLOSE.equals(token)) {
                    // invalid, ignore
                } else {
                    current.append(token);
                }
            }
        }
        outside.append(current.toString());
        new TitleProcessor(outside.toString()).add(result);
        return result;
    }

    private static String getSplitRegex(String delimiterRegex) {
        // http://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
        // use lookahead and lookbehind to split the string
        return "(?<=" + delimiterRegex + ")|(?=" + delimiterRegex + ")";
    }

    public static void main(String[] args) throws Exception {
        // in filename, tag is defined as [name.value with spaces]
        // there is an implicit tag [value with spaces]
        // what is outside the tag definition is appended to the "title" tag
        File file = new File("dump/data/[comic] poems about water[i.01].png");
        FileNameParser parser = new FileNameParser();
        System.out.println(parser.parse(file));
    }
}
