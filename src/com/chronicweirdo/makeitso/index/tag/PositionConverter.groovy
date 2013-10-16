package com.chronicweirdo.makeitso.index.tag

import com.chronicweirdo.makeitso.graph.ConvertFromNode
import com.chronicweirdo.makeitso.graph.ConvertToNode;
import com.chronicweirdo.makeitso.graph.Node;

class PositionConverter implements ConvertToNode<Position>,
		ConvertFromNode<Position> {

	@Override
	public Position convertFromNode(Node node) {
		if (node.value[0] != "position") return null;
		Position p = new Position();
		p.path = Paths.get(node.value[1]);
		p.line = Integer.parseInt(node.value[2]);
		return p;
	}

	@Override
	public Node convertToNode(Position object) {
		return new Node("position", object.path.toString(), object.line.toString());
	}

}
