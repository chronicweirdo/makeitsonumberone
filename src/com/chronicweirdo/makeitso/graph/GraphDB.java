package com.chronicweirdo.makeitso.graph;

public interface GraphDB<T> {

	void save(T where, Graph graph);
	
	Graph load(T fromWhere);
}
