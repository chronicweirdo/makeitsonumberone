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

    /*@Test
    public void patch() throws Exception {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = Scanner.scan(patchRoot);

        Map<Entry, Entry> details = Matcher.match(patch, files);
        for (Map.Entry<Entry, Entry> entry: details.entrySet()) {
            System.out.println(entry.getKey().getName() + " --- " + (entry.getValue() != null ? entry.getValue().getName() : null));
        }

        // TODO: notify users which files were not found and remove them

        Patcher.patch(root, patchRoot, details, Long.toString(System.currentTimeMillis()));
    }

    @Test
    public void revert() throws Exception {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = new ArrayList<Entry>();
        Entry p1 = new Entry();
        p1.setName(Arrays.asList("integration-servlet.xml.1413552579542".split(Scanner.DOT_LINE_SPLITTER_KEEPER)));
        patch.add(p1);
        Entry p2 = new Entry();
        p2.setName(Arrays.asList("ipaweb-1.0.320701.jar.1413552579542".split(Scanner.DOT_LINE_SPLITTER_KEEPER)));
        patch.add(p2);

        Map<Entry, Entry> details = Matcher.match(patch, files);
        for (Map.Entry<Entry, Entry> entry: details.entrySet()) {
            System.out.println(entry.getKey().getName() + " --- " + (entry.getValue() != null ? entry.getValue().getName() : null));
        }

        // TODO: notify users which files were not found and remove them

        Patcher.patch(root, patchRoot, details, null);
    }*/

    /*@Test
    public void testPatch() throws Exception {
        String root = "C:\\ipaserver\\web\\WEB-INF";
        List<Entry> files = Scanner.scan(root);
        String patchRoot = "C:\\patch";
        List<Entry> patch = Scanner.scan(patchRoot);

        List<Pair<Entry>> pairs = new ArrayList<Pair<Entry>>();
        Scorer scorer = new SimilarityScorer();
        for (Entry patchFile: patch) {
            System.out.println(patchFile.getNameString());
            MatchCollection result = new MatchCollection(scorer, patchFile);
            for (Entry file: files) {
                result.addMatch(file);
            }
            System.out.println(result.getMatches().toString());
            System.out.println();
            pairs.add(new Pair<Entry>(result.getMatch(), patchFile));
        }

        String label = "label";
        Patcher.patch(root, patchRoot, patchRoot, label, pairs);
    }*/

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
        Patcher.patch(root, patchRoot, backupRoot, label, link);
    }
}
