package org.chronicweirdo.dump.service;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.Set;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class FileNameParserTest {

    @Test
    public void testParse1() throws Exception {
        FileNameParser fileNameParser = new FileNameParser();
        String fileName = "[y.2014][mo.11][d.12][h.10][m.00][i.01][t.comic][t.blobs][ti.blobs go to the theater].jpg";
        Map<String, Set<String>> tags = fileNameParser.parse(fileName);
        System.out.println(tags);
        assertEquals(tags.get("month").size(), 1);
        assertTrue(tags.get("month").contains("11"));
        assertEquals(tags.get("day").size(), 1);
        assertTrue(tags.get("day").contains("12"));
        assertEquals(tags.get("tag").size(), 2);
        assertTrue(tags.get("tag").contains("comic"));
        assertTrue(tags.get("tag").contains("blobs"));
        assertEquals(tags.get("title").size(), 1);
        assertTrue(tags.get("title").contains("blobs go to the theater"));
        assertEquals(tags.get("hour").size(), 1);
        assertTrue(tags.get("hour").contains("10"));
        assertEquals(tags.get("year").size(), 1);
        assertTrue(tags.get("year").contains("2014"));
        assertEquals(tags.get("index").size(), 1);
        assertTrue(tags.get("index").contains("01"));

    }
}
