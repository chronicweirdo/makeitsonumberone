package org.chronicweirdo.patcher.matcher;

import org.chronicweirdo.patcher.scanner.Entry;

/**
 * Created by scacoveanu on 11/7/2014.
 */
public interface Scorer {

    double score(Entry source, Entry entry);
}
