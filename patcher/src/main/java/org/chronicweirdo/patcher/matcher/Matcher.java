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

    public static Map<Entry, Entry> match(List<Entry> patch, List<Entry> files) {
        // build index ?
        // pass 1 - find matches for each patch file
        Map<Entry, List<Entry>> matches = new HashMap<Entry, List<Entry>>(patch.size());
        for (Entry p: patch) {
            matches.put(p, match(p, files));
        }
        // pass 2 - select only the best match
        Map<Entry, Entry> result = new HashMap<Entry, Entry>(patch.size());
        for (Map.Entry<Entry, List<Entry>> e: matches.entrySet()) {
            if (e.getValue().size() == 0) {
                result.put(e.getKey(), null);
            } else if (e.getValue().size() == 1) {
                result.put(e.getKey(), e.getValue().get(0));
            } else {
                result.put(e.getKey(), getBest(e.getKey(), e.getValue()));
            }
        }
        return result;
    }

    private static Entry getBest(Entry key, List<Entry> value) {
        Entry best = value.get(0);
        /*double score = matchScore(key, best);
        for (int i = 1; i < value.size(); i++) {
            double newScore = matchScore(key, value.get(i));
            if (newScore > score) {
                score = newScore;
                best = value.get(i);
            }
        }*/
        return best;
    }

    private static List<Entry> match(Entry patch, List<Entry> files) {
        List<Entry> result = new ArrayList<Entry>(1);
        for (Entry file: files) {
            if (SimilarityCalculator.similarity(patch.getName(), file.getName()) > 0) {
                result.add(file);
            }
        }
        return result;
    }

    /*private static boolean match(Entry patch, Entry file) {
        //return matchScore(patch, file) > 0;
        //return patch.getName().get(0).equals(file.getName().get(0));
        return ;
    }*/

    /*private static double matchScore(Entry patch, Entry file) {
        // if they don't have the same extension, they don't match
        //if (! patch.getExtension().equalsIgnoreCase(file.getExtension())) return 0;

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
    }*/

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
