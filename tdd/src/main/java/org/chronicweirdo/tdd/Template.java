package org.chronicweirdo.tdd;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 5/22/2014.
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
        String result = replaceVariables();
        checkForMissingValues(result);
        return result;
    }

    private String replaceVariables() {
        String result = templateText;
        for (Map.Entry<String, String> entry: variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        return result;
    }

    private void checkForMissingValues(String result) {
        Matcher matcher = Pattern.compile(".*\\$\\{.+\\}.*").matcher(result);
        if (matcher.find()) {
            throw new MissingValueException("No value for " + matcher.group());
        }
    }
}
