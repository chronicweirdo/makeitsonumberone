package org.chronicweirdo.junk.graph;

import java.util.Set;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class TagsUtil {

    public static boolean equals(Set<Tag> tags1, Set<Tag> tags2) {
        if (tags1.size() != tags2.size()) {
            return false;
        }
        if (! tags1.containsAll(tags2)) {
            return false;
        }
        if (! tags2.containsAll(tags1)) {
            return false;
        }
        return false;
    }
}
