package org.chronicweirdo.junk.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class Link {

    private Node source;
    private Node destination;
    private List<Tag> tags = new ArrayList<Tag>();

    public Link(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }


}
