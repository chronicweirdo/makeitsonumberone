package org.chronicweirdo.junk;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.regex.Pattern;

/**
 * Created by scacoveanu on 6/16/2014.
 */
public class RegexPatternPrintTest {

    @Test
    public void listRegexPattern() throws Exception {
        String patternString = ".*([a-z]+).*";
        Pattern pattern = Pattern.compile(patternString);
        System.out.println(pattern.toString());
        assertEquals(patternString, pattern.toString());
    }

}
