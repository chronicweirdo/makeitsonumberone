package org.chronicweirdo.junk.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class MapIdentifierQuery implements Query {

    private Map<String, String> map = new HashMap<String, String>();

    public MapIdentifierQuery(Map<String, String> map) {
        this.map = map;
    }

    public MapIdentifierQuery(String ... map) {
        if (map.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < map.length; i+=2) {
            this.map.put(map[i], map[i+1]);
        }
    }

    @Override
    public Graph filter(Graph graph) {
        Graph result = new Graph();
        for (Map.Entry<Identifier, Node> entry: graph.nodes.entrySet()) {
            Identifier id = entry.getKey();
            if (id instanceof MapIdentifier) {
                MapIdentifier mapId = (MapIdentifier) id;
                if (matches(mapId)) {
                    result.nodes.put(id, entry.getValue());
                }
            }
        }
        return result;
    }

    private boolean matches(MapIdentifier id) {
        for (Map.Entry<String, String> entry: this.map.entrySet()) {
            if (id.get(entry.getKey()) == null) {
                return false;
            }
            if (! entry.getValue().equals(id.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
