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
}
