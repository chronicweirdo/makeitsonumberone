package org.chronicweirdo.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 5/22/2014.
 *
 * Spike - (Extreme Programming vocabulary) the exploratory process of figuring out whether a given solution would solve
 * our problem or what might be the best approach to solving a given problem.
 */
public class Template {

    private String templateText;

    private Map<String, String> variables;

    public Template(String templateText) {
        this.variables = new HashMap<String, String>();
        this.templateText = templateText;
    }

    public void set(String variable, String value) {
        this.variables.put(variable, value);
    }

    public String evaluate() {
        TemplateParse parser = new TemplateParse();
        List<String> segments = parser.parse(templateText);
        StringBuilder result = new StringBuilder();
        for (String segment: segments) {
            append(segment, result);
        }
        return result.toString();
    }

    private void append(String segment, StringBuilder result) {
        if (segment.startsWith("${") && segment.endsWith("}")) {
            String variable = segment.substring(2, segment.length() - 1);
            if (!variables.containsKey(variable)) {
                throw new MissingValueException("No value for " + segment);
            }
            result.append(variables.get(variable));
        } else {
            result.append(segment);
        }
    }
}
