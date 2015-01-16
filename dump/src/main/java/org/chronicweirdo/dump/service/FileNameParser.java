package org.chronicweirdo.dump.service;

import javafx.geometry.Pos;
import jdk.internal.util.xml.impl.Pair;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service that will take the file name and extract all available tags from it.
 * Tag syntax is [tag.value].
 * Created by scacoveanu on 12/29/2014.
 */
public class FileNameParser {

    private static final String PATTERN = "\\[([^.]*)\\.([^\\]]+)\\]";
    public static final String TAG_CLOSE = "]";
    public static final String TAG_OPEN = "[";

    // accepted tags and synonyms
    private static Map<String, String> formal;
    private static Map<String, String> copy;

    public static final String TITLE = "title";

    public static final String EXTENSION = "extension";

    public static final String YEAR = "year";

    public static final String MONTH = "month";

    public static final String DAY = "day";

    public static final String HOUR = "hour";

    public static final String MINUTE = "minute";

    public static final String TAG = "tag";

    public static final String INDEX = "index";

    public static final String CAPTION = "caption";

    public static final String PROCESSOR = "processor";

    static {
        formal = new HashMap<String, String>();

        formal.put(EXTENSION, EXTENSION);

        formal.put(YEAR, YEAR);
        formal.put("y", YEAR);

        formal.put(MONTH, MONTH);
        formal.put("mo", MONTH);

        formal.put(DAY, DAY);
        formal.put("d", DAY);

        formal.put(HOUR, HOUR);
        formal.put("h", HOUR);

        formal.put(MINUTE, MINUTE);
        formal.put("m", MINUTE);

        formal.put(TAG, TAG);
        formal.put("t", TAG);

        formal.put(INDEX, INDEX);
        formal.put("i", INDEX);

        formal.put(CAPTION, CAPTION);
        formal.put("c", CAPTION);

        formal.put(TITLE, TITLE);
        formal.put("ti", TITLE);

        formal.put(PROCESSOR, PROCESSOR);
        formal.put("p", PROCESSOR);

        copy = new HashMap<String, String>();

        copy.put(EXTENSION, PROCESSOR);
    }

    public static Map<String, Set<String>> parse(String fileName) {
        String[] tokens = splitStringKeepSpaces(fileName);
        Map<String, Set<String>> processResult = process(tokens);
        Map<String, Set<String>> postProcessResult = postProcess(processResult);
        return postProcessResult;
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
                name = "tag";
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
            addToMap(map, TITLE, title.trim());
            if (extension != null) {
                addToMap(map, EXTENSION, extension.trim().toLowerCase());
            }
        }
    }

    private static Map<String, Set<String>> process(String[] words) {
        boolean tag = false;
        Map<String, Set<String>> result = new HashMap<>();
        StringBuilder outside = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (String word: words) {
            if (tag) {
                if (TAG_CLOSE.equals(word)) {
                    tag = false;
                    new TagProcessor(current.toString()).add(result);
                    current = new StringBuilder();
                } else if (TAG_OPEN.equals(word)) {
                    // invalid, but ignore
                } else {
                    current.append(word);
                }
            } else {
                if (TAG_OPEN.equals(word)) {
                    tag = true;
                    outside.append(current.toString());
                    current = new StringBuilder();
                } else if (TAG_CLOSE.equals(word)) {
                    // invalid, ignore
                } else {
                    current.append(word);
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
        String name = "[created.201411041800][comic][pun] the pun is here.jpg";
        FileNameParser parser = new FileNameParser();
        System.out.println(parser.parse(name));
        name = "[created.201411041800][comic][pun][p.img] the pun is here.jpg";
        System.out.println(parser.parse(name));
    }
}
