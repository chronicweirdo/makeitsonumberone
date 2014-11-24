package org.chronicweirdo.patcher.matcher;

import java.util.List;

/**
 * Created by scacoveanu on 10/31/2014.
 */
public class SimilarityCalculator {

    public static int similarity(String token1, String token2) {
        int[] root = rootSize(token1, token2);
        return root[0];
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
}
