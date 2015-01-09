package org.chronicweirdo.dump.parsers;

import org.chronicweirdo.dump.Util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 1/9/2015.
 */
public class TagExtractor {

    public static final String DEFAULT_PATTERN = "\\[([^.]*)\\.([^\\]]+)\\]";

    private String pattern;

    private Map<String, String> formalize;

    private boolean strict = false;

    private String defaultKey;

    public TagExtractor(String pattern) {
        this.pattern = pattern;
    }

    public void setFormalize(Map<String, String> formalize) {
        this.formalize = formalize;
    }

    public void setStrict(boolean strict) {
        this.strict = strict;
    }

    public void setDefaultKey(String defaultKey) {
        this.defaultKey = defaultKey;
    }

    public Map<String, Set<String>> parse(String string) {
        Map<String, Set<String>> tags = new HashMap<String, Set<String>>();
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            String tag = matcher.group(1);
            String value = matcher.group(2);
            String formalTag = formalize.get(tag);


            if (formalTag != null) {
                if (!tags.containsKey(formalTag)) {
                    tags.put(formalTag, new HashSet<String>());
                }
                tags.get(formalTag).add(value);
            }
        }
        return tags;
    }

    public static void main(String[] args) {
        TagExtractor tagExtractor = new TagExtractor(DEFAULT_PATTERN);
        tagExtractor.setFormalize(Util.map(
                "year", "year",
                "y", "year",
                "month", "month",
                "mo", "month",
                "day", "day",
                "d", "day",
                "h", "hour",
                "m", "minute",
                "t", "tag",
                "i", "index",
                "c", "caption",
                "ti", "title",
                "p", "processor"
        ));
    }
}
