package org.chronicweirdo.junk.exceptions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 7/7/2014.
 */
public class TestReturnWithFinally {

    @Test
    public void codeInFinallyShouldRun() throws Exception {
        try {
            assertTrue(true); // doing something
            System.out.println("doing something");
            return;
        } finally {
            assertTrue(true);
            System.out.println("should get here");
        }
    }
}
