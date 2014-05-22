package org.chronicweirdo.tdd;

/**
 * Created by scacoveanu on 5/22/2014.
 */
public class Template {

    private String variableValue;

    public Template(String templateText) {

    }

    public void set(String variable, String value) {
        this.variableValue = value;
    }

    public String evaluate() {
        return "Hello, " + variableValue;
    }
}
