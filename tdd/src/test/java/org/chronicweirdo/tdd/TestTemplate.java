package org.chronicweirdo.tdd;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 5/22/2014.
 */
public class TestTemplate {

    // fixture - the state for all tests
    private Template template;

    @Before
    public void setUp() throws Exception {
        template = new Template("${one}, ${two}, ${three}");
        template.set("one", "1");
        template.set("two", "2");
        template.set("three", "3");
    }

    @Test
    public void multipleVariables() throws Exception {
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    private void assertTemplateEvaluatesTo(String expected) {
        assertEquals(expected, template.evaluate());
    }

    /*
     * Evaluating template "Hello, ${name}" with no value for variable "name" raises a MissingValueError.
     */
    @Test
    public void missingValueRaisesException() throws Exception {
        try {
            new Template("${foo}").evaluate();
            fail("evaluate() should throw an exception if a variable was left without a value!");
        } catch (MissingValueException expected) {
            assertEquals("No value for ${foo}", expected.getMessage());
        }
    }

    @Test
    public void unknownVariablesAreIgnored() throws Exception {
        template.set("doesnotexist", "whatever");
        assertTemplateEvaluatesTo("1, 2, 3");
    }

    /*
     * Evaluate template "${one}, ${two}, ${three}" with values "1", "${foo}" and "3" and verify that the template
     * engine renders the result as "1, ${foo}, 3".
     */

}
