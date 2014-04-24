package com.chronicweirdo.makeitso.index.tag.old20131016

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;

import java.nio.file.Path

@EqualsAndHashCode
class Position {

	Path path; // a relative path
	Integer line;
	Set<Tag> tags = new HashSet<Tag>();
	
	Position(path, line) {
		this.path = path;
		this.line = line;
	}
	
	@Override
	public String toString() {
		return "($path, $line)"
	}
	
	Position filePosition() {
		return new Position(this.path, null);
	}
}
