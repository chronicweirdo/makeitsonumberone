package org.chronicweirdo.junk.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class Graph {

    protected Map<Identifier, Node> nodes = new HashMap<Identifier, Node>();
    private List<Link> links = new ArrayList<Link>();

    public void addNode(Node node) {
        nodes.put(node.getId(), node);
    }

    public Node node(MapIdentifier id) {
        if (nodes.containsKey(id)) {
            return nodes.get(id);
        }
        return null;
    }

    public Graph filter(Query query) {
        return query.filter(this);
    }

    public int nodesSize() {
        return nodes.size();
    }
}
