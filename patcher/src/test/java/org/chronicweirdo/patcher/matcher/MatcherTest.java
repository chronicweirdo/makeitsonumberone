package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;
import org.chronicweirdo.patcher.scanner.Scanner;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class MatcherTest {

    @Test
    public void matchStringScore() throws Exception {
        String patch = "ipaweb-1.0-SNAPSHOT.jar";
        String file = "ipaweb-1.0.213456.jar";

        double score = Matcher.matchScore(patch, file);

        assertEquals(score, (double) 10 / Math.max(patch.length(), file.length()), 0.0001d);
    }

    @Test
    public void match() throws Exception {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = Scanner.scan(patchRoot);

        Map<Entry, Object> result = Matcher.match(patch, files);
        for (Map.Entry<Entry, Object> entry: result.entrySet()) {
            System.out.println(entry.getKey().getName() + " --- " + entry.getValue());
        }
    }
}
