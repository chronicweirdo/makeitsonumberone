package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.util.Set;

class GDB {

	Map<Path,Map<Integer, Set<Link>>> positionToLinkIndex = new HashMap();
	Map<String,Map<String, Set<Link>>> tagToLinkIndex = new HashMap();
	
	Set tags = new HashSet();
	Set positions = new HashSet();
	Set links = new HashSet();
	
	Tag tag(String name, String value) {
		if (tagToLinkIndex[name] == null) tagToLinkIndex[name] = [:];
		if (tagToLinkIndex[name][value] == null) tagToLinkIndex[name][value] = new HashSet();
		Tag tag = getOrAdd(tags, new Tag(name, value));
		
	}
	
	void removeTag(Tag tag) {
		tags.remove(tag);
	}
	
	Position position(Path path, int num) {
		return getOrAdd(positions, new Position(path, num));
	}
	
	void removePosition(Position position) {
		positions.remove(position)
	}
	
	Link link(Tag tag, Position position) {
		return getOrAdd(links, new Link(tag, position));
	}
	
	void removeLink(Link link) {
		links.remove(link);
	}
	
	void removeLinks(Set links) {
		this.links.removeAll(links);
	}
	
	Set findLinksByTag(Tag tag) {
		Set r = new HashSet();
		for (Link l: links) {
			if (l.tag.equals(tag)) r.add(l);
		}
		return r;
	}
	
	Set findLinksByPosition(Position position) {
		Set r = new HashSet();
		for (Link l: links) {
			if (l.position == position) return r.add(l);
		}
		return r;
	}
	
	/**
	 * Find equivalent object in a set.
	 */
	Object getOrAdd(Set set, Object o) {
		for (Object e: set) {
			if (o.equals(e)) return e;
		}
		// add the object
		set.add(o);
		return o;
	}
}
