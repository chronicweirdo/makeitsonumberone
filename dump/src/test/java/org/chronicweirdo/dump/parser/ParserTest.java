package org.chronicweirdo.dump.parser;

import org.chronicweirdo.dump.service.Parser;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 12/29/2014.
 */
public class ParserTest {

    @Test
    public void testParse1() throws Exception {
        Parser parser = new Parser();
        String fileName = "[y.2014][mo.11][d.12][h.10][m.00][i.01][t.comic][t.blobs][ti.blobs go to the theater].jpg";
        Map<String, List<String>> tags = parser.parse(fileName);
        System.out.println(tags);
    }
}
