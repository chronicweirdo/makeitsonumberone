package org.chronicweirdo.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 5/23/2014.
 */
public class TemplateParse {
    public List<String> parse(String template) {
        List<String> segments = new ArrayList<String>();
        int index = collectSegments(segments, template);
        addTail(segments, template, index);
        addEmptyStringIfTemplateWasEmpty(segments);
        return segments;
    }

    private void addEmptyStringIfTemplateWasEmpty(List<String> segments) {
        if (segments.isEmpty()) {
            segments.add("");
        }
    }

    private void addTail(List<String> segments, String template, int index) {
        if (index < template.length()) {
            segments.add(template.substring(index));
        }
    }

    private int collectSegments(List<String> segments, String source) {
        Pattern pattern = Pattern.compile("\\$\\{[^}]*\\}");
        Matcher matcher = pattern.matcher(source);
        int index = 0;
        while (matcher.find()) {
            addPrecedingPlainText(segments, source, matcher, index);
            addVariable(segments, source, matcher);
            index = matcher.end();
        }
        return index;
    }

    private void addPrecedingPlainText(List<String> segments, String source, Matcher matcher, int index) {
        if (index != matcher.start()) {
            segments.add(source.substring(index, matcher.start()));
        }
    }

    private void addVariable(List<String> segments, String source, Matcher matcher) {
        segments.add(source.substring(matcher.start(), matcher.end()));
    }


    public List<Segment> parseSegments(String template) {
        return null;
    }
}
