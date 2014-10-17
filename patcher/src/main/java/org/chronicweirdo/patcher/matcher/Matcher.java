package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 10/17/2014.
 */
public class Matcher {

    public static Map<Entry, Object> match(List<Entry> patch, List<Entry> files) {
        // build index ?
        // find match for each patch file
        Map<Entry, Object> result = new HashMap<Entry, Object>(patch.size());
        for (Entry p: patch) {
            result.put(p, match(p, files));
        }
        return result;
    }

    private static Object match(Entry patch, List<Entry> files) {
        List<Entry> result = new ArrayList<Entry>(1);
        for (Entry file: files) {
            if (match(patch, file)) {
                result.add(file);
            }
        }
        if (result.size() == 0) {
            return null;
        } else if (result.size() == 1) {
            return result.get(0);
        } else {
            return result;
        }
    }

    private static boolean match(Entry patch, Entry file) {
        //return matchScore(patch, file) > 0;
        return patch.getName().get(0).equals(file.getName().get(0));
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
