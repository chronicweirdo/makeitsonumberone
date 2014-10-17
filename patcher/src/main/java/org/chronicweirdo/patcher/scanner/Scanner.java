package org.chronicweirdo.patcher.scanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class Scanner {

    public static final String DOT_SPLITTER = "\\.";
    public static final String DOT_LINE_SPLITTER = "\\.|\\-";
    public static final String DOT_LINE_SPLITTER_KEEPER = "(?<=" + DOT_LINE_SPLITTER + ")|(?=" + DOT_LINE_SPLITTER + ")";

    public static List<Entry> scan(String root) {
        File r = new File(root);
        return scan(r);
    }

    private static List<Entry> scan(File file) {
        if (! file.exists()) {
            return new ArrayList<Entry>(0);
        } else {
            List<Entry> list = new ArrayList<Entry>();
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    list.addAll(scan(child));
                }
            } else {
                list.add(extract(file));
            }
            return list;
        }
    }

    private static Entry extract(File file) {
        Entry entry = new Entry();
        entry.setName(Arrays.asList(file.getName().split(DOT_LINE_SPLITTER_KEEPER)));
        entry.setPath(Arrays.asList(file.getAbsolutePath().split("\\\\|/")));
        return entry;
    }
}
