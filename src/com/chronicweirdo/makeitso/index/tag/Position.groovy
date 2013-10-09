package com.chronicweirdo.makeitso.index.tag

import groovy.transform.ToString;

import java.nio.file.Path

class Position {

	Path path; // a relative path
	int line;
	Set<Tag> tags = new HashSet<Tag>();
	
	Position(path, line) {
		this.path = path;
		this.line = line;
	}
	
	@Override
	public int hashCode() {
		return path.hashCode() * 31 + line.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			return path.equals(obj.path) && line.equals(obj.line)
		} else return false 
	}
	
	@Override
	public String toString() {
		return "($path,$line)"
	}
}
