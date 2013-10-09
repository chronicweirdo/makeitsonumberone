package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths
import java.util.Set;

import com.chronicweirdo.makeitso.file.FileUtils

class Index {

	Path root;
	Set<Position> positions = new HashSet<Position>();
	Set<Tag> tags = new HashSet<Tag>();
	Set<Link> links = new HashSet<Link>();
	
	Index(Path root) {
		this.root = root
	}
	
	/**
	 * Process a file by reading each line and recording the tags to the index.
	 * @param file
	 */
	void process(Path file) {
		// get full path of the file
		Path full = root.resolve(file)
		// open the file
		// process each line
		int num = 0
		new File(full.toString()).eachLine { line -> 
			process(position(file, num), line)
			num++
		}
		// close the file
	}
	
	Position position(Path file, int line) {
		Position p = new Position(file, line);
		Position r = get(positions, p);
		if (r) {
			return r;
		} else {
			positions.add(p);
			return p;
		}
	}
	
	Tag tag(String name, String value) {
		Tag t = new Tag(name, value);
		Tag r = get(tags, t);
		if (r) return r;
		else {
			tags.add(t);
			return t;
		}
	}
	
	/**
	 * Find equivalent object in a set.
	 */
	Object get(Object o, Set set) {
		for (Object e: set) {
			if (o.equals(e)) return e;
		}
		return null;
	}
	
	Set<Link> findLinks(Position position) {
		Set<Link> r = new HashSet<Link>();
		for (Link l: links) {
			if (l.position.equals(position)) r.add(l);
		}
		return r;
	}
	
	Set<Link> findLinks(Tag tag) {
		Set<Link> r = new HashSet<Link>();
		for (Link l: links) {
			if (l.tag.equals(tag)) r.add(l);
		}
		return r;
	}
	
	void process(Position position, String line) {
		// get existing links
		Set<Link> tagLinks = findLinks(position);
		// construct existing links
		Tag.tags(line).each {
			// get the actual tag
			Tag tag = tag(it.name, it.value);
			
		}
	}
	
	void add(Tag tag, Position position) {
		tags.
	}
	
	static main(args) {
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Path path = Paths.get("bbp", "apache_jena.txt");
		
		Index index = new Index(root)
		index.process(path)
		
		println index.exact
		println index.name
		println index.value
	}

}
