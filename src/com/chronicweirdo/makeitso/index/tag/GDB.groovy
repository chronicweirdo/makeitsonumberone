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
		return getOrAdd(tags, new Tag(name, value));		
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
		Link n = new Link(tag, position);
		Link r = links.find {it == n};
		if (r) return r; // all is well, we have the link
		links.add(n);
		// add to indexes
		if (tagToLinkIndex[tag.name] == null) tagToLinkIndex[tag.name] = [:]
		if (tagToLinkIndex[tag.name][tag.value] == null)
			tagToLinkIndex[tag.name][tag.value] = new HashSet();
		tagToLinkIndex[tag.name][tag.value].add(n);
		if (positionToLinkIndex[position.path] == null) positionToLinkIndex[position.path] = [:];
		if (positionToLinkIndex[position.path][position.line] == null)
			positionToLinkIndex[position.path][position.line] = new HashSet();
		positionToLinkIndex[position.path][position.line].add(n);
		return n;
	}
	
	void removeLink(Link link) {
		links.remove(link);
		// remove from indexes
		tagToLinkIndex[link.tag.name][link.tag.value].remove(link);
		positionToLinkIndex[link.position.path][link.position.line].remove(link);
	}
	
	void removeLinks(Set links) {
		links.each {
			removeLink(it)
		}
	}
	
	Set findLinksByTag(Tag tag) {
		if (tagToLinkIndex[tag.name] && tagToLinkIndex[tag.name][tag.value]) {
			return tagToLinkIndex[tag.name][tag.value];
		}
		return new HashSet();
	}
	
	Set findLinksByPosition(Position position) {
		if (positionToLinkIndex[position.path] 
			&& positionToLinkIndex[position.path][position.line]) {
			return positionToLinkIndex[position.path][position.line];
		}
		return new HashSet();
	}
	
	/**
	 * Find equivalent object in a set.
	 */
	Object getOrAdd(Set set, Object o) {
		Object f = set.find {it == o};
		if (f) return f;
		set.add(o);
		return o;
	}
}
