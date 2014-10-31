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

    //@Test
    public void tokenSimilarity() {
        assertAndPrint(SimilarityCalculator.similarity("analysis", "analisis"), 0.5);
        assertAndPrint(SimilarityCalculator.similarity("analysis", "analysis"), 1);
        assertAndPrint(SimilarityCalculator.similarity("analysisa", "analysisaa"), 0.9);
        assertAndPrint(SimilarityCalculator.similarity("ana", "analysisaa"), 0.3);
        assertAndPrint(SimilarityCalculator.similarity("beans", "analysisaa"), 0.0);
    }

    //@Test
    public void listSimilarity() {
        assertAndPrint(SimilarityCalculator.similarity(l("analysis", "-", "api"), l("analysis", "-", "api")), 1);
        assertAndPrint(SimilarityCalculator.similarity(l("analysis", "-", "api", "1", ".", "0"), l("analysis", "-", "api", "1", ".", "1")), 0.933333);
        assertAndPrint(SimilarityCalculator.similarity(l("analysis", "1", ".", "0"), l("analysis", "-", "api", "1", ".", "0")), 0.888888);
        assertAndPrint(SimilarityCalculator.similarity(l("dataset", "1", ".", "0"), l("analysis", "-", "api", "1", ".", "0")), 0.0);
        assertAndPrint(SimilarityCalculator.similarity(l("analysiz", "1", ".", "0"), l("analysis", "-", "api", "1", ".", "0")), 0.0);
    }

    @Test
    public void percentageSimilarityProblem() {
        List<String> patch = l("analysis", "-", "api", "-", "1", ".", "158744");
        List<String> correctMatch = l("analysis", "-", "api", "-", "1", ".", "887426"); // this should be considered the closer match
        List<String> wrongMatch = l("analysiz", "-", "1"); // this should be a worse match

        double correctMatchScore = SimilarityCalculator.similarity(patch, correctMatch);
        System.out.println(correctMatchScore);
        double wrongMatchScore = SimilarityCalculator.similarity(patch, wrongMatch);
        System.out.println(wrongMatchScore);

        assertTrue(correctMatchScore > wrongMatchScore); // this fails, the score should only consider the number of leading characters that are
    }

    private void assertAndPrint(double value, double expectedValue) {
        System.out.println(value);
        assertEquals(value, expectedValue, 0.0001);
    }

    private List<String> l(String ... s) {
        return Arrays.asList(s);
    }
}
