package org.chronicweirdo.tdd;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 5/23/2014.
 */
public class TestPlainTextSegment {

    @Test
    public void plainTextEvaluateAsIs() throws Exception {
        Map<String, String> variables = new HashMap<String, String>();
        String text = "abc def";
        assertEquals(text, new PlainText(text).evaluate(variables));
    }
}
