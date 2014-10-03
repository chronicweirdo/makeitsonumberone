package org.chronicweirdo.junk.graph;

import org.chronicweirdo.junk.graph.Identifier;
import org.chronicweirdo.junk.graph.Link;
import org.chronicweirdo.junk.graph.Node;

import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public interface Query {

    Graph filter(Graph graph);
}
