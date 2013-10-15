package com.chronicweirdo.makeitso.graph.indexgraph

class Graph {

	Set<Node> nodes;
	Set<Link> links;
	
	Graph() {
		nodes = new HashSet();
		links = new HashSet();
	}
	Graph(Set<Node> nodes, Set<Link> links) {
		this.nodes = nodes;
		this.links = links;
	}
	
	void merge(Graph graph) {
		this.nodes.addAll(graph.nodes);
		this.links.addAll(graph.links);
	}
	
	void delete(Graph graph) {
		this.links.removeAll(graph.links);
		this.deleteFreeNodes();
	}
	
	/**
	 * Will extract the specified nodes from the graph. All existing nodes and links linked to the
	 * given set will also be included in the new graph.
	 * @param nodes
	 * @return
	 */
	Graph extract(Set<Node> nodes) {
		Set<Link> links = new HashSet();
		nodes.each {
			links.add(findLinksFrom(it));
			links.add(findLinksTo(it));
		}
		Set<Node> allNodes = new HashSet();
		links.each {
			allNodes.add(it.from);
			allNodes.add(it.to);
		}
		Graph result = new Graph(allNodes, links);
		return result;
	}
	
	void deleteFreeNodes() {
		Set<Node> freeNodes = findFreeNodes();
		nodes.removeAll(freeNodes);
	}
	
	Set<Node> findFreeNodes() {
		Set<Node> linked = new HashSet();
		links.each {
			linked.add(it.from);
			linked.add(it.to);
		}
		Set<Node> result = new HashSet(nodes);
		result.removeAll(linked);
		return result;
	}
	
	Set<Link> findLinksFrom(Node from) {
		Set<Link> result = new HashSet();
		links.each {
			if (it.from == from) result.add(it);
		}
		return result;
	}
	
	Set<Link> findLinksTo(Node to) {
		Set<Link> result = new HashSet();
		links.each {
			if (it.to == to) result.add(it);
		}
		return result;
	}
}
