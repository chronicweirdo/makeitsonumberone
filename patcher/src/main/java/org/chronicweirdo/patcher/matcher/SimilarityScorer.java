package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;

/**
 * Created by scacoveanu on 11/7/2014.
 */
public class SimilarityScorer implements Scorer {

    @Override
    public double score(Entry source, Entry entry) {
        if (source.getPath() != null && source.getPath().size() > 0) {
            String sourcePath = source.getRelativePath();
            String entryPath = source.getRelativePath();
            if (! sourcePath.equals(entryPath)) {
                return 0;
            }
        }
        return SimilarityCalculator.similarity(source.getNameString(), entry.getNameString());
    }
}
