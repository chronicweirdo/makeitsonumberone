package com.chronicweirdo.makeitso.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.StructureUtils;

public class Graph extends GREL {

	private static final long serialVersionUID = -1079160807225788580L;
	
	private List<Node> nodes = new ArrayList<Node>();
	private List<Link> links = new ArrayList<Link>();
	private List<Graph> graphs = new ArrayList<Graph>();
	
	public GREL get(Condition condition) throws Exception {
		List<GREL> result = filter(condition);
		if (result.size() == 0) {
			return null;
		} else if (result.size() == 1) {
			return result.get(0);
		} else {
			throw new Exception("graph broken, multiple ids");
		}
	}
	
	public void add(GREL element) throws Exception {
		if (element instanceof Node) {
			nodes.add((Node) element);
		} else if (element instanceof Link) {
			links.add((Link) element);
		} else if (element instanceof Graph) {
			graphs.add((Graph) element);
		} else {
			throw new Exception("unsuported element");
		}
	}
	
	public List<GREL> delete(GREL element) throws Exception {
		if (element instanceof Node) {
			List<GREL> result = new ArrayList<GREL>();
			Node node = (Node) element;
			// remove all links with this node
			LinkEndCondition condition = new LinkEndCondition(
					new AttributeEqualsCondition("path", node.get("path"))
				);
			List<GREL> links = filter(condition);
			for (GREL link: links) {
				result.addAll(delete(link));
			}
			// remove node
			this.nodes.remove(node);
			result.add(node);
			return result;
		} else if (element instanceof Link) {
			// simple, just remove the link
			Link link = (Link) element;
			this.links.remove(link);
			return (List<GREL>) StructureUtils.list(link);
		} else {
			throw new Exception("unsuported delete operation");
		}
	}
	
	public List<GREL> filter(Condition condition) {
		List<GREL> result = new ArrayList<GREL>();
		for (Node node: nodes) {
			if (condition.evaluate(node)) {
				result.add(node);
			}
		}
		for (Link link: links) {
			if (condition.evaluate(link)) {
				result.add(link);
			}
		}
		for (Graph graph: graphs) {
			if (condition.evaluate(graph)) {
				result.add(graph);
			}
		}
		return result;
	}
	
	public void print() {
		for (Node node: nodes) {
			System.out.println(node.toString());
		}
		System.out.println();
		for (Link link: links) {
			System.out.println(link.toString());
		}
		System.out.println();
		System.out.println("no subgraph printing support yet\n");
		System.out.println(nodes.size() + " nodes, " + links.size() + " links, " + graphs.size() + " subgraphs");
	}
}
