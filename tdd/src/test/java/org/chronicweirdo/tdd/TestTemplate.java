package org.chronicweirdo.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 5/22/2014.
 */
public class TestTemplate {

    @Test
    public void oneVariable() throws Exception {
        Template template = new Template("Hello, ${name}");
        template.set("name", "Reader");
        assertEquals("Hello, Reader", template.evaluate());
    }

    @Test
    public void differentTemplate() throws Exception {
        Template template = new Template("Hi, ${name}");
        template.set("name", "someone else");
        assertEquals("Hi, someone else", template.evaluate());
    }

    @Test
    public void multipleVariables() throws Exception {
        Template template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
        assertEquals("1, 2, 3", template.evaluate());
    }

    /**
     * Evaluating template "Hello, ${name}" with no value for variable "name" raises a MissingValueError.
     */

    /**
     * Evaluating template "Hello, ${name}" with values "Hi" and "Reader" for variables "doesnotexist" and "name",
     * respectively, results in the string "Hello, Reader".
     */

    /**
     * Evaluate template "${one}, ${two}, ${three}" with values "1", "${foo}" and "3" and verify that the template
     * engine renders the result as "1, ${foo}, 3".
     */
}
