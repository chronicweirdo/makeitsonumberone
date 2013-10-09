package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.file.FileUtils

class Index {

	Path root;
	Map<String, Set<Position>> value = new HashMap<String, Set<Position>>();
	Map<String, Set<Position>> name = new HashMap<String, Set<Position>>();
	Map<Tag, Set<Position>> exact = new HashMap<Tag, Set<Position>>();

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
			process(new Position(file, num), line)
			num++
		}
		// close the file
	}
	
	void process(Position position, String line) {
		Tag.tags(line).each {
			add(it, position)
		}
	}
	
	void add(Tag tag, Position position) {
		if (exact[tag] == null) exact[tag] = new HashSet<Position>();
		exact[tag].add(position);
		if (name[tag.name] == null) name[tag.name] = new HashSet<Position>();
		name[tag.name].add(position);
		if (value[tag.value] == null) value[tag.value] = new HashSet<Position>();
		value[tag.value].add(position);
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
