package com.chronicweirdo.makeitso.index.tag;

public class Entry {
	Tag tag;
	Position position;
	
	Entry(Tag tag, Position position) {
		this.tag = tag;
		this.position = position;
	}
	
	@Override
	public String toString() {
		return tag.toString() + " " + position.toString();
	}
}
