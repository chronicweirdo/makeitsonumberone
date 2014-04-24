package com.chronicweirdo.makeitso.graph

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.file.FileUtils
import com.chronicweirdo.protection.SerializationUtil

class GraphBinaryDB implements GraphDB<Path> {

	@Override
	public void save(Path where, Graph graph) {
		byte[] data = SerializationUtil.serialize(graph);
		FileUtils.writeFile(where.toString(), data);
	}

	@Override
	public Graph load(Path fromWhere) {
		byte[] data = FileUtils.readFile(fromWhere.toString());
		Graph graph = (Graph) SerializationUtil.deserialize(data);
		return graph;
	}

	static main(args) {
		Graph g = Graph.testGraph();
		GraphBinaryDB db = new GraphBinaryDB();
		Path path = Paths.get("serializedGraph.exo");
		
		db.save(path, g);
		
		Graph gg = db.load(path);
		
		println gg.toString();
	}
}
