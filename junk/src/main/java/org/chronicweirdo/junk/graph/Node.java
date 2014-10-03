package org.chronicweirdo.junk.graph;

import java.util.*;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class Node implements Tagged {

    private Set<Tag> tags = new HashSet<Tag>();

    private Identifier identifier = new AllTagsIdentifier();

    public Node() {

    }

    @Override
    public Set<Tag> getTags() {
        return new HashSet<Tag>(tags);
    }

    public Node(String ... tags) {
        if (tags.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < tags.length; i+=2) {
            this.tags.add(new Tag(tags[i], tags[i+1]));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return identifier.equals(this, node);
    }

    @Override
    public int hashCode() {
        return identifier.hashCode(this);
    }
}
