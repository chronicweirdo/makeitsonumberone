package org.chronicweirdo.dump.service;

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

    // accepted tags and synonyms
    private static Map<String, String> formal;

    public static final String TITLE = "title";

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

        System.out.println("--- formal size: " + formal.size());
    }

    public static Map<String, Set<String>> parse(String fileName) {
        Map<String, Set<String>> tags = new HashMap<String, Set<String>>();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(fileName);
        while (matcher.find()) {
            String tag = matcher.group(1);
            String value = matcher.group(2);
            // find formal tag name
            String formalTag = formal.get(tag);
            if (formalTag != null) {
                if (!tags.containsKey(formalTag)) {
                    tags.put(formalTag, new HashSet<String>());
                }
                tags.get(formalTag).add(value);
            }
        }
        return tags;
    }

    public static void splitStringKeepSpaces(String line) throws Exception {
        String delimiterRegex = "([\\[\\]])";
        String splitRegex = getSplitRegex(delimiterRegex);

        String[] words = line.split(splitRegex);
        for (String word: words) {
            System.out.println(">" + word + "<");
        }

        process(words);
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
            System.out.println(name + " :: " + value);
        }

        private void add(Map<String, List<String>> map) {
            addToMap(map, name, value);
        }
    }

    private static void addToMap(Map<String, List<String>> map, String name, String value) {
        if (! map.containsKey(name)) {
            map.put(name, new ArrayList<String>());
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

        private void add(Map<String, List<String>> map) {
            addToMap(map, "title", title);
            if (extension != null) {
                addToMap(map, "extension", extension);
            }
        }
    }

    public static Map<String, List<String>> process(String[] words) {
        boolean tag = false;
        Map<String, List<String>> result = new HashMap<>();
        StringBuilder outside = new StringBuilder();
        StringBuilder current = new StringBuilder();
        for (String word: words) {
            if (tag) {
                if ("]".equals(word)) {
                    tag = false;
                    new TagProcessor(current.toString()).add(result);
                    current = new StringBuilder();
                } else if ("[".equals(word)) {
                    // invalid, but ignore
                } else {
                    current.append(word);
                }
            } else {
                if ("[".equals(word)) {
                    tag = true;
                    outside.append(current.toString());
                    current = new StringBuilder();
                } else if ("]".equals(word)) {
                    // invalid, ignore
                } else {
                    current.append(word);
                }
            }
        }
        outside.append(current.toString());
        new TitleProcessor(outside.toString()).add(result);
        System.out.println(result);
        return null;
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
        splitStringKeepSpaces(name);
    }
}
