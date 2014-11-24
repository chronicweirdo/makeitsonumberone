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

    private static Entry getBest(Entry key, List<Entry> value) {
        Entry best = value.get(0);
        return best;
    }

    private static List<Entry> match(Entry patch, List<Entry> files) {
        List<Entry> result = new ArrayList<Entry>(1);
        for (Entry file: files) {
            if (SimilarityCalculator.similarity(patch.getNameString(), file.getNameString()) > 0) {
                result.add(file);
            }
        }
        return result;
    }
}
