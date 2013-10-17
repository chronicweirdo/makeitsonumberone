package com.chronicweirdo.makeitso.graph



class Graph {

	//Set<Node> nodes;
	Set<Link> links;
	Map<String, Object> properties = [:];
	
	Graph() {
		links = new HashSet();
	}
	
	Graph(Set<Link> links) {
		this.links = links;
	}
	
	void add(Link link) {
		links.add(link);
	}
	
	void merge(Graph graph) {
		this.links.addAll(graph.links);
	}
	
	void delete(Graph graph) {
		this.links.removeAll(graph.links);
	}
	
	/*void setProperty (String property, Object o) {
		properties[property] = o;
	}
	
	Object getProperty (String property) {
		return properties[property];
	}*/
	
	
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
		Graph result = new Graph(links);
		return result;
	}
	Set<Node> findNodesLike(List<String> regex) {
		return findNodesLike(regex, false);
	}
	Set<Node> findNodesLike(List<String> regex, boolean strict) {
	
		Set<Node> checked = new HashSet();
		Set<Node> result = new HashSet();
		links.each {
			Node node = it.from;
			if (!checked.contains(node)) {
				checked.add(node);
				if (node.matches(regex, strict)) result.add(node); 
			}
			node = it.to;
			if (!checked.contains(node)) {
				checked.add(node);
				if (node.matches(regex, strict)) result.add(node);
			}
		}
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
	
	void delete(Node node) {
		links.removeAll(findLinksFrom(node));
		links.removeAll(findLinksTo(node));
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		properties.each { name, value ->
			b.append(name).append(" = ").append(value.toString()).append("\n");
		}
		links.each {
			b.append(it.toString()).append("\n");
		}
		return b.toString();
	}
	
	static main(args) {
		/*
		(tag,tech,apache)-(file,file1,1)
		(tag,overview)-(file,file1,2)
		(tag,date,2013.10.14)-(file,file1,3)
		(link,http://....)-(file,file1,8)
		(tag,tech,lucene)-(file,file2,1)
		(tag,overview)-(file,file2,1)
		(disk,pretty_image.png)-(file,file2,3)
		(tag,apache)-(file,file2,1)
		(tag,index)-(file,file2,1)
		(tag,code)-(file,file2,2)
		(tag,todo,tech)-(file,file3,1)
		(tag,tech,lucene)-(file,file3,2)
		(tag,tech,solr)-(file,file3,3)
		 */
		def a = new Node("tag","tech","apache")
		def b = new Node("tag","tech","apache")
		println a == b;
		
		Graph g = new Graph();
		g.updated = "yesterday";
		g.add(new Link(new Node("tag","tech"), new Node("file","file1","1")));
		g.add(new Link(new Node("tag","tech","apache"), new Node("file","file1","1")));
		g.add(new Link(new Node("tag","overview"), new Node("file","file1","2")));
		g.add(new Link(new Node("tag","date","2013.10.14"), new Node("file","file1","3")));
		g.add(new Link(new Node("link","http://jgrapht.org/"), new Node("file","file1","8")));
		g.add(new Link(new Node("tag","tech","lucene"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","overview"), new Node("file","file2","1")));
		g.add(new Link(new Node("disk","pretty_image.png"), new Node("file","file2","3")));
		g.add(new Link(new Node("tag","apache"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","index"), new Node("file","file2","1")));
		g.add(new Link(new Node("tag","code"), new Node("file","file2","2")));
		g.add(new Link(new Node("tag","todo","tech"), new Node("file","file3","1")));
		g.add(new Link(new Node("tag","tech","lucene"), new Node("file","file3","2")));
		g.add(new Link(new Node("tag","tech","solr"), new Node("file","file3","3")));
		
		print g.toString();
		
		println g.findNodesLike(["tag","tech"]);
		println g.findNodesLike(["tag","t.*"]);
		println g.findNodesLike(["tag","t.*"], true);
	}
}
