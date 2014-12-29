package org.chronicweirdo.dump.service;

import jdk.internal.util.xml.impl.Pair;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Service that will take the file name and extract all available tags from it.
 * Tag syntax is [tag.value].
 * Created by scacoveanu on 12/29/2014.
 */
public class Parser {

    private static final String PATTERN = "\\[([^.]*)\\.([^\\]]+)\\]";

    // accepted tags and synonyms
    private static Map<String, String> formal;

    {
        formal = new HashMap<String, String>();

        formal.put("year", "year");
        formal.put("y", "year");

        formal.put("month", "month");
        formal.put("mo", "month");

        formal.put("day", "day");
        formal.put("d", "day");

        formal.put("hour", "hour");
        formal.put("h", "hour");

        formal.put("minute", "minute");
        formal.put("m", "minute");

        formal.put("tag", "tag");
        formal.put("t", "tag");

        formal.put("index", "index");
        formal.put("i", "index");

        formal.put("caption", "caption");
        formal.put("c", "caption");

        formal.put("title", "title");
        formal.put("ti", "title");
    }

    public Map<String, List<String>> parse(String fileName) {
        Map<String, List<String>> tags = new HashMap<String, List<String>>();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(fileName);
        while (matcher.find()) {
            String tag = matcher.group(1);
            String value = matcher.group(2);
            // find formal tag name
            String formalTag = formal.get(tag);
            if (formalTag != null) {
                if (!tags.containsKey(formalTag)) {
                    tags.put(formalTag, new ArrayList<String>());
                }
                tags.get(formalTag).add(value);
            }
        }
        return tags;
    }
}
