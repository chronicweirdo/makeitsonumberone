package com.ingenuity.temp.apiupload;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by scacoveanu on 5/28/2014.
 */

public class ParameterParsingTest {

    @Test
    public void testParsingEmptyString() throws Exception {
        List<Pair> result = parse("");
        assertEquals(result.size(), 0);
    }

    private List<Pair> parse(String parameters) {
        MainUI mainUI = new MainUI();
        return mainUI.parseParameters(parameters);
    }

    @Test
    public void testParsingOneParameter() throws Exception {
        List<Pair> parameters = parse("one=value1");
        assertEquals(parameters.size(), 1);
        assertParameter(parameters, 0, "one", "value1");
    }

    @Test
    public void testParsingTwoParameters() throws Exception {
        List<Pair> parameters = parse("one=value1&two=value2");
        assertEquals(parameters.size(), 2);
        assertParameter(parameters, 0, "one", "value1");
        assertParameter(parameters, 1, "two", "value2");
    }

    private void assertParameter(List<Pair> parameters, int index, String expectedName, String expectedValue) {
        assertTrue(parameters.size() > index);
        Pair parameter = parameters.get(index);
        assertEquals(parameter.getKey(), expectedName);
        assertEquals(parameter.getValue(), expectedValue);
    }
}
