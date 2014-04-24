package com.chronicweirdo.makeitso.graph.neo4j

import java.nio.file.Path
import java.nio.file.Paths

import org.neo4j.graphdb.DynamicLabel
import org.neo4j.graphdb.GraphDatabaseService
import org.neo4j.graphdb.Label
import org.neo4j.graphdb.Node
import org.neo4j.graphdb.Relationship
import org.neo4j.graphdb.RelationshipType
import org.neo4j.graphdb.ResourceIterator
import org.neo4j.graphdb.Transaction
import org.neo4j.graphdb.factory.GraphDatabaseFactory
import org.neo4j.graphdb.schema.IndexCreator
import org.neo4j.graphdb.schema.IndexDefinition
import org.neo4j.graphdb.schema.Schema

/**
 * Test done following tutorial at:
 * 
 * 		http://docs.neo4j.org/chunked/snapshot/tutorials-java-embedded-setup.html
 * 
 * 
 * @author cacovean
 *
 */
class TestNeo4j {

	public static enum RelTypes implements RelationshipType {
		TAGGED,
		ONTOLOGY
	}

	static void registerShutdownHook( final GraphDatabaseService graphDb ) {
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running application).
		Runtime.getRuntime().addShutdownHook( new Thread()
				{
					@Override
					public void run()
					{
						graphDb.shutdown();
					}
				} );
	}

	static createIndex(graph, String forWhat, String onWhat) {
		IndexDefinition indexDefinition;
		try {
			Transaction tx = graph.beginTx()
			Schema schema = graph.schema();
			IndexCreator creator = schema.indexFor(DynamicLabel.label(forWhat)).on(onWhat);
			creator.create()
			tx.success();
			tx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static GraphDatabaseService open(Path path) {
		boolean exists = path.toFile().exists();
		def graphDb = new GraphDatabaseFactory()
				.newEmbeddedDatabase(path.toString());
		/*
		 .setConfig([
		 "neostore.nodestore.db.mapped_memory": "10M",
		 "string_block_size": "60",
		 "array_block_size": "300",
		 ])
		 .newGraphDatabase();*/
		if (!exists) createIndex(graphDb, "Node", "id");
		registerShutdownHook(graphDb);
		return graphDb;
	}

	static void addLink(GraphDatabaseService graph, node1M, node2M, linkM, linkType) {
		try {
			Transaction tx = graph.beginTx()
			Label label = DynamicLabel.label("Node");
			// create indexes
			//IndexManager index = graph.index().forNodes("uniques");
			// Database operations go here
			Node node1 = graph.createNode(label);
			node1M.each { k, v -> 
				println "setting property $k :: $v"
				node1.setProperty(k, v) 
			}
			
			//index.add(node1, "id", node1M["id"]);
			Node node2 = graph.createNode(label);
			node2M.each { k, v ->
				println "setting property $k :: $v"
				node2.setProperty(k, v)
			}
			//index.add(node2, "id", node2M["id"]);
			Relationship link = node1.createRelationshipTo(node2, linkType);
			linkM.each { k, v -> link.setProperty(k, v) }
			tx.success();
			tx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void findNodeByIndex(graph, value) {
		// find node by index
		try {
			Transaction tx = graph.beginTx()
			ResourceIterator<Node> users = graph.findNodesByLabelAndProperty( DynamicLabel.label("Node"), "id", value )
			.iterator();
			ArrayList<Node> userNodes = new ArrayList<>();
			while ( users.hasNext() )
			{
				userNodes.add( users.next() );
			}
			println "found $userNodes.size nodes"
			for ( Node node : userNodes )
			{
				node.getProperties().each { k, v ->
					println "$k :: $v"
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static main(args) {
		Path path = Paths.get("/Users/cacovean/Documents/workspace/makeitso", "testNeo4jDB");
		def graph = open(path);

		long now = System.currentTimeMillis();
		
		addLink(graph, ["id":"1", "type": "file", "value": "home/test.txt"],
		["id":"2", "value":"#tech:test", "type": "tag"]
		, ["from": now], RelTypes.TAGGED);

		findNodeByIndex(graph, "1");
	}

}
