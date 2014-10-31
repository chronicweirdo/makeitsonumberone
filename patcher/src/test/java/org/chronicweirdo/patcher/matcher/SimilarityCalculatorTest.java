package org.chronicweirdo.patcher.matcher;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 10/31/2014.
 */
public class SimilarityCalculatorTest {

    /*
    Similarity between two files:
        based on file name
            file name split into tokens
            a score is computed based on the similarity of the tokens
        based on path
            a score is computed based on (reverse) path similarity/equality?
     */

    @Test
    public void tokenSimilarity() {
        assertAndPrint(SimilarityCalculator.similarity("analysis", "analisis"), 4);
        assertAndPrint(SimilarityCalculator.similarity("analysis", "analysis"), 8);
        assertAndPrint(SimilarityCalculator.similarity("analysisa", "analysisaa"), 9);
        assertAndPrint(SimilarityCalculator.similarity("ana", "analysisaa"), 3);
        assertAndPrint(SimilarityCalculator.similarity("beans", "analysisaa"), 0);
    }

    @Test
    public void percentageSimilarityProblem() {
        String patch = "analysis-api-1.158744";
        String correctMatch = "analysis-api-1.887426"; // this should be considered the closer match
        String wrongMatch = "analysiz-1"; // this should be a worse match

        double correctMatchScore = SimilarityCalculator.similarity(patch, correctMatch);
        System.out.println(correctMatchScore);
        double wrongMatchScore = SimilarityCalculator.similarity(patch, wrongMatch);
        System.out.println(wrongMatchScore);

        assertTrue(correctMatchScore > wrongMatchScore); // this fails, the score should only consider the number of leading characters that are
    }

    private void assertAndPrint(int value, int expectedValue) {
        System.out.println(value);
        assertEquals(value, expectedValue);
    }

    private List<String> l(String ... s) {
        return Arrays.asList(s);
    }
}
