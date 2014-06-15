package org.chronicweirdo.empetrei;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/15/14.
 */
public class TestTagHandler extends AbstractTagTest {

    @Test
    public void testTagRead() {
        TagHandler handler = new TagHandler();
        Tag tag = handler.getTag(filePathWithCover);
        assertNotNull(tag);
    }
}
