package org.chronicweirdo.patcher.matcher;

import org.junit.Test;
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
}
