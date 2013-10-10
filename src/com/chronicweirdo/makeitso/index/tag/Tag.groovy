package com.chronicweirdo.makeitso.index.tag

class Tag {
	String name;
	String value;
	Set<Position> positions = new HashSet<Position>();
	
	public Tag() {}
	
	public Tag(String name, String value) {
		this.name = name;
		this.value = value;
	}
	
	@Override
	public String toString() {
		if (value) return "#$name:$value"
		return "#$name"
	}
	
	@Override
	public int hashCode() {
		if (value) return name.hashCode() * 31 + value.hashCode();
		else return name.hashCode() * 31
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Tag) {
			if (value) return name.equals(obj.name) && value.equals(obj.value)
			return name.equals(obj.name) && obj.value == null
		} else return false
	}



	static List<Tag> tags(String text) {
		List<Tag> result = new ArrayList<Tag>();
		def matcher = text =~ /(#([a-zA-Z][\w.]*)([:]([\w.]+))?)/
		for (match in matcher) {
			Tag tag = new Tag()
			//println "!$match"
			tag.name = match[2]
			tag.value =match[4]
			result.add(tag);
		}
		return result
	}
}
