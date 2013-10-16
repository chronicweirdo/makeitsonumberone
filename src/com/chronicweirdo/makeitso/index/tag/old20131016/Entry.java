package com.chronicweirdo.makeitso.index.tag.old20131016;

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
