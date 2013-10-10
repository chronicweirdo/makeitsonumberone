package com.chronicweirdo.makeitso.index.tag

class Link {
	Tag tag;
	Position position;
	
	public Link(Tag tag, Position position) {
		this.tag = tag;
		this.position = position;
	}
	
	@Override
	public int hashCode() {
		return tag.hashCode() * 31 + position.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Link) {
			return tag.equals(obj.tag) && position.equals(obj.position);
		} else return false;
	}
	
	@Override
	public String toString() {
		return "(" + tag.toString() + " - " + position.toString() + ")";
	}
}
