package org.chronicweirdo.junk.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 10/3/2014.
 */
public class QueriesUseCases {

    private Graph graph;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();

        // populate with data
        /*graph.addNode(new Node("artist", "Deftones", "title", "Drive"));
        graph.addNode(new Node("artist", "Deftones", "title", "Mx"));
        graph.addNode(new Node("artist", "NoFX", "title", "Leaving Jesusland"));*/
    }

    /*@Test
    public void gettingNodeById() throws Exception {
        MapIdentifier id = new MapIdentifier("artist", "Deftones", "title", "Drive");
        Node node = graph.node(id);

        assertNotNull(node);
        assertEquals(id, node.getId());
    }*/

    /*@Test
    public void filterNodes() throws Exception {
        Query query = new MapIdentifierQuery("artist", "Deftones");
        Graph result = graph.filter(query);

        assertEquals(2, result.nodesSize());
        for (Node node: result.nodes.values()) {
            MapIdentifier id = (MapIdentifier) node.getId();
            assertEquals("Deftones", id.get("artist"));
        }

    }*/
    
}

