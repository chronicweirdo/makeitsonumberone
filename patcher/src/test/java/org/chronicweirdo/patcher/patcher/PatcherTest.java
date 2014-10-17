package org.chronicweirdo.patcher.patcher;

import org.chronicweirdo.patcher.fileops.Patcher;
import org.chronicweirdo.patcher.matcher.Matcher;
import org.chronicweirdo.patcher.scanner.Entry;
import org.chronicweirdo.patcher.scanner.Scanner;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    }


}
