package org.chronicweirdo.junk.regex;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 2/23/2015.
 */
public class IPFiltering {

    @Test
    public void splitIPAddress() throws Exception {
        String ip = "129.135.1.2";
        String[] tokens = ip.split("\\.");
        assertEquals(tokens.length, 4);
        assertEquals(tokens[0], "129");
        assertEquals(tokens[1], "135");
        assertEquals(tokens[2], "1");
        assertEquals(tokens[3], "2");
    }


    /*
    List expression: 129.135.1.2, 133.142.3.80, 187.2.4.3
    Range expression: 164.234.3.1 - 164.234.3.100
     */
    @Test
    public void splitCriteria() throws Exception {
        String expression = "129.135.1.2, 133.142.3.80, 164.234.3.1 - 164.234.3.100, 187.2.4.*";

        // remove spaces
        expression = expression.replaceAll("\\s", "");

        // split composite expression into independent expressions
        String[] expressions = expression.split("\\Q,\\E");
        assertEquals(expressions.length, 4);
        assertEquals(expressions[0], "129.135.1.2");
        assertEquals(expressions[1], "133.142.3.80");
        assertEquals(expressions[2], "164.234.3.1-164.234.3.100"); // collapse this into 164.234.3.1-100 ???
        assertEquals(expressions[3], "187.2.4.*");

    }

    public static interface IPExpression {
        boolean matches(String ipAddress);
    }
}
