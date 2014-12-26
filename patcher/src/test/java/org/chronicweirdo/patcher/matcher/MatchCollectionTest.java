package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;
import org.chronicweirdo.patcher.scanner.Scanner;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 11/7/2014.
 */
public class MatchCollectionTest {

    @Test
    public void testCollectionMatch() {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = Scanner.scan(patchRoot);

        Scorer scorer = new SimilarityScorer();
        for (Entry patchFile: patch) {
            System.out.println(patchFile.getNameString());
            MatchCollection result = new MatchCollection(scorer, patchFile);
            for (Entry file: files) {
                result.addMatch(file);
            }
            System.out.println(result.getMatches().toString());
            System.out.println();
        }
    }

    /**
     * Test to verify if backed-up files with a label in the name are still matched to the correct files.
     */
    @Test
    public void testBackupMatch() {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);

        List<Entry> patch = new ArrayList<Entry>();
        patch.add(Scanner.extract(new File("integration-web.xml.orig"), new ArrayList<String>()));
        patch.add(Scanner.extract(new File("ipaweb-1.0.320701.jar.orig"), new ArrayList<String>()));

        Scorer scorer = new SimilarityScorer();
        for (Entry patchFile: patch) {
            System.out.println(patchFile.getNameString());
            MatchCollection result = new MatchCollection(scorer, patchFile);
            for (Entry file: files) {
                result.addMatch(file);
            }
            System.out.println(result.getMatches().toString());
            System.out.println();
        }
    }
}
