package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Paths

import com.chronicweirdo.makeitso.graph.ConvertFromNode
import com.chronicweirdo.makeitso.graph.ConvertToNode
import com.chronicweirdo.makeitso.graph.Node

class PositionConverter implements ConvertToNode<Position>,
		ConvertFromNode<Position> {

	@Override
	public Position convertFromNode(Node node) {
		if (node.value[0] != "position") return null;
		Position p = new Position();
		String path = "";
		node.value[1..-2].each { path += it + "/" }
		p.path = Paths.get(path);
		p.line = Integer.parseInt(node.value[-1]);
		return p;
	}

	@Override
	public Node convertToNode(Position object) {
		def list = ["position"]
		object.path.iterator().each {
			list.add(it.toString())
		}
		if (object.line) list.add(object.line.toString());
		return new Node(list);
	}

}
