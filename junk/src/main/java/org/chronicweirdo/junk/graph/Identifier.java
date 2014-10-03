package org.chronicweirdo.junk.graph;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public interface Identifier {

    boolean equals(Tagged tagged1, Tagged tagged2);

    int hashCode(Tagged tagged);
}
