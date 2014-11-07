package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by scacoveanu on 10/31/2014.
 */
public class MatchCollection {

    private Scorer scorer;
    private Entry source;
    private List<Entry> matches = new ArrayList<Entry>();
    private Double score;
    private double threshold = 0;

    public MatchCollection(Scorer scorer, Entry source) {
        this.scorer = scorer;
        this.source = source;
    }

    public void addMatch(Entry newEntry) {
        // if there is no match, add it
        double score = scorer.score(source, newEntry);
        if (score > threshold) {
            if (matches.size() == 0) {
                matches.add(newEntry);
                this.score = score;
            } else {
                // if there is a match
                if (this.score < score) {
                    this.score = score;
                    matches.clear();
                    matches.add(newEntry);
                } else if (this.score.equals(score)) {
                    matches.add(newEntry);
                }
                //      check the score of the match
                //      if it is larger than the score of the existing matches, remove all matches and keep the new one
                //      if it is the same as the score of the existing matches,
            }
        }
    }

    public int size() {
        return matches.size();
    }

    public List<Entry> getMatches() {
        return matches;
    }

    public Entry getMatch() {
        if (matches.size() != 1) {
            throw new UnsupportedOperationException();
        }
        return matches.get(0);
    }
}
