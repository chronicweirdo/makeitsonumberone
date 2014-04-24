package com.chronicweirdo.makeitso.index.tag

class Pair {

	Tag tag;
	Position position;
	
	@Override
	public String toString() {
		return "(" + position.toString() + " - " + tag.toString() + ")";
	}
}
