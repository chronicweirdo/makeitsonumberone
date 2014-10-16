package org.chronicweirdo.junk.regex;

import org.junit.Test;

/**
 * Created by scacoveanu on 10/16/2014.
 */
public class SpltStringKeepDelimiters {

    @Test
    public void splitStringKeepSpaces() throws Exception {
        String delimiterRegex = "(\\s+)"; // selects each space as a token, why?
        String splitRegex = getSplitRegex(delimiterRegex);

        String line = "this is  a simple\tline";
        String[] words = line.split(splitRegex);

        for (String word: words) {
            System.out.println(">" + word + "<");
        }
    }

    private String getSplitRegex(String delimiterRegex) {
        // http://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
        // use lookahead and lookbehind to split the string
        return "(?<=" + delimiterRegex + ")|(?=" + delimiterRegex + ")";
    }
}
