package com.chronicweirdo.makeitso.index.tag

import com.chronicweirdo.makeitso.graph.ConvertFromNode
import com.chronicweirdo.makeitso.graph.ConvertToNode;
import com.chronicweirdo.makeitso.graph.Node;

class TagConverter implements ConvertToNode<Tag>, ConvertFromNode<Tag> {

	@Override
	public Tag convertFromNode(Node node) {
		if (node.value[0] != "tag") return null;
		Tag t = new Tag();
		for (i in 1..node.value.size()) {
			t.values.add(node.value[i]);
		}
		return t;
	}

	@Override
	public Node convertToNode(Tag object) {
		Node n = new Node();
		n.value.add("tag");
		n.value.addAll(object.values);
		return n;
	}

}
