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
}
