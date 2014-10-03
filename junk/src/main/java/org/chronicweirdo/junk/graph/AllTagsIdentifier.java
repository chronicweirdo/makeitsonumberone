package org.chronicweirdo.junk.graph;

import java.util.Set;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class AllTagsIdentifier implements Identifier {

    @Override
    public boolean equals(Tagged tagged1, Tagged tagged2) {
        Set<Tag> tags1 = tagged1.getTags();
        Set<Tag> tags2 = tagged2.getTags();
        return TagsUtil.equals(tags1, tags2);
    }

    @Override
    public int hashCode(Tagged tagged) {
        int result = 0;
        for (Tag tag: tagged.getTags()) {
            result = 31 * result + tag.hashCode();
        }
        return result;
    }
}
