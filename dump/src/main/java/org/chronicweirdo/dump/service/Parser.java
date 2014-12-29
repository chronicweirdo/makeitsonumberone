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

    public Map<String, List<String>> parse(String fileName) {
        Map<String, List<String>> tags = new HashMap<String, List<String>>();
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(fileName);
        while (matcher.find()) {
            String tag = matcher.group(1);
            String value = matcher.group(2);
            if (! tags.containsKey(tag)) {
                tags.put(tag, new ArrayList<String>());
            }
            tags.get(tag).add(value);
        }
        return tags;
    }
}
