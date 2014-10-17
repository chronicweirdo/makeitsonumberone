package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;

import java.util.List;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class Matcher {

    public static List<Tuple> match(List<Entry> patch, List<Entry> files) {
        // build index ?
        // find match for each patch file

        return null;
    }

    private static Tuple match(Entry patch, List<Entry> files) {

        return null;
    }

    private static boolean match(Entry patch, Entry file) {
        return matchScore(patch, file) > 0;
    }

    private static double matchScore(Entry patch, Entry file) {
        // if they don't have the same extension, they don't match
        if (! patch.getExtension().equalsIgnoreCase(file.getExtension())) return 0;

        String patchName, fileName;
        if (patch.getPath().size() > 0) {
            patchName = merge(patch.getPath(), patch.getName());
            fileName = merge(file.getPath(), file.getName());
        } else {
            patchName = merge(patch.getName());
            fileName = merge(file.getName());
        }
        return matchScore(patchName, fileName);
    }

    protected static double matchScore(String patch, String file) {
        double max = Math.max(patch.length(), file.length());
        int index = 0;
        while ((index < patch.length()) && (index < file.length())
                && (patch.charAt(index) == file.charAt(index))) {
            index += 1;
        }
        return (double)index / max;
    }

    private static String merge(List<String> ... lists) {
        StringBuilder builder = new StringBuilder();
        for (List<String> list: lists) {
            for (String string: list) {
                builder.append(string);
            }
        }
        return builder.toString();
    }



}
