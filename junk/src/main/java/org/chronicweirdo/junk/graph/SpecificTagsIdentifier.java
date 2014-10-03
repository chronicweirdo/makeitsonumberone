package org.chronicweirdo.junk.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class SpecificTagsIdentifier implements Identifier {

    private Set<String> tags = new HashSet<String>();

    public SpecificTagsIdentifier(String ... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    private Set<Tag> filter(Tagged tagged) {
        Set<Tag> tags = tagged.getTags();
        Set<Tag> filtered = new HashSet<Tag>();
        for (Tag tag: tags) {
            if (this.tags.contains(tag.getName())) {
                filtered.add(tag);
            }
        }
        return filtered;
    }

    @Override
    public boolean equals(Tagged tagged1, Tagged tagged2) {
        Set<Tag> tags1 = filter(tagged1);
        Set<Tag> tags2 = filter(tagged2);
        return TagsUtil.equals(tags1, tags2);
    }

    @Override
    public int hashCode(Tagged tagged) {
        int result = 0;
        for (Tag tag: filter(tagged)) {
            result = 31 * result + tag.hashCode();
        }
        return result;
    }
}
