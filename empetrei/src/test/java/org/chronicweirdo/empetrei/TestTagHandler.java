package org.chronicweirdo.empetrei;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/15/14.
 */
public class TestTagHandler {

    @Test
    public void testTagRead() {
        String filePath = "";
        TagHandler handler = new TagHandler();
        Tag tag = handler.getTag(filePath);
        assertNotNull(tag);
    }
}
