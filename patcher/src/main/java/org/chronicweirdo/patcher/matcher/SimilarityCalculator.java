package org.chronicweirdo.patcher.matcher;

import java.util.List;

/**
 * Created by scacoveanu on 10/31/2014.
 */
public class SimilarityCalculator {

    public static double similarity(String token1, String token2) {
        int[] root = rootSize(token1, token2);
        double score = (double) root[0] / root[1];
        return score;
    }

    private static int[] rootSize(String token1, String token2) {
        int max = Math.max(token1.length(), token2.length());
        boolean equal = true;
        int index = 0;
        while ((index < token1.length()) && (index < token2.length()) && (equal)) {
            if (token1.charAt(index) == token2.charAt(index)) {
                index++;
            } else {
                equal = false;
            }
        }
        return new int[] {index, max};
    }

    public static double similarity(List<String> tokens1, List<String> tokens2) {
        int index = 0; // index up to which this string sequences are equal
        int max = 0;
        boolean cont = true;
        for (int i = 0; (i < tokens1.size()) && (i < tokens2.size()) && (cont); i++) {
            int[] root = rootSize(tokens1.get(i), tokens2.get(i));
            if (root[0] != root[1]) {
                cont = false;
            }
            index += root[0];
            max += root[1];
        }
        double score = (double) index / max;
        return score;
    }
}
