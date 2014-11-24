package org.chronicweirdo.patcher.patcher;

import org.chronicweirdo.patcher.fileops.Pair;
import org.chronicweirdo.patcher.fileops.Patcher;
import org.chronicweirdo.patcher.matcher.MatchCollection;
import org.chronicweirdo.patcher.matcher.Matcher;
import org.chronicweirdo.patcher.matcher.Scorer;
import org.chronicweirdo.patcher.matcher.SimilarityScorer;
import org.chronicweirdo.patcher.scanner.Entry;
import org.chronicweirdo.patcher.scanner.Scanner;
import org.junit.Test;

import java.util.*;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class PatcherTest {

    @Test
    public void patch() throws Exception {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = Scanner.scan(patchRoot);

        Scorer scorer = new SimilarityScorer();
        Map<Entry, Entry> link = new HashMap<Entry, Entry>();
        for (Entry patchFile: patch) {
            System.out.println(patchFile.getNameString());
            MatchCollection result = new MatchCollection(scorer, patchFile);
            for (Entry file: files) {
                result.addMatch(file);
            }
            System.out.println(result.getMatches().toString());
            System.out.println();
            link.put(result.getMatch(), patchFile);
        }

        String label = "orig";
        String backupRoot = "~";
        Patcher.patch(root, patchRoot, backupRoot, label, link, false);
    }
}
