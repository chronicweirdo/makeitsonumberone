package org.chronicweirdo.tdd;

import java.util.HashMap;
import java.util.Map;

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
        String result = templateText;
        for (Map.Entry<String, String> entry: variables.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            result = result.replaceAll(regex, entry.getValue());
        }
        if (result.matches(".*\\$\\{.+\\}.*")) {
            throw new MissingValueException();
        }
        return result;
    }
}
