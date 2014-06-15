package org.chronicweirdo.empetrei;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Silviu on 6/15/14.
 */
public class TestTagHandler {

    @Test
    public void testTagRead() {
        String filePath = "C:\\Users\\Silviu\\Dropbox\\music\\chiptune\\Disasterpeace - The Great Oulu Fire of 2082.mp3";
        TagHandler handler = new TagHandler();
        Tag tag = handler.getTag(filePath);
        assertNotNull(tag);
    }
}
