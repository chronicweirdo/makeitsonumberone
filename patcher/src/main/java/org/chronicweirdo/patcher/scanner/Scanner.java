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

    private static List<Entry> scan(File root) {
        if (! root.isDirectory()) {
            return null;
        } else {
            List<Entry> result = new ArrayList<Entry>();
            for (File child : root.listFiles()) {
                result.addAll(scan(new ArrayList<String>(), child));
            }
            return result;
        }
    }

    private static List<String> add(List<String> list, String element) {
        List<String> result = new ArrayList<String>(list);
        result.add(element);
        return result;
    }

    private static List<Entry> scan(List<String> path, File file) {
        if (! file.exists()) {
            return new ArrayList<Entry>(0);
        } else {
            List<Entry> list = new ArrayList<Entry>();
            if (file.isDirectory()) {
                path = add(path, file.getName());
                for (File child : file.listFiles()) {
                    list.addAll(scan(path, child));
                }
            } else {
                list.add(extract(file, path));
            }
            return list;
        }
    }

    public static Entry extract(File file, List<String> path) {
        Entry entry = new Entry();
        entry.setName(Arrays.asList(file.getName().split(DOT_LINE_SPLITTER_KEEPER)));
        entry.setPath(path);
        return entry;
    }
}
