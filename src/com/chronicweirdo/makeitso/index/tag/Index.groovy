package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import java.nio.file.Paths
import java.util.Set;

import com.chronicweirdo.makeitso.file.FileUtils

class Index {

	Path root;
	GDB db = new GDB();
	
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
			process(db.position(file, num), line)
			num++
		}
		// close the file
	}
	
	void process(Position position, String line) {
		// get existing links
		Set<Link> existingLinks = db.findLinksByPosition(position);
		// construct new links
		Set<Link> currentLinks = new HashSet<Link>();
		Tag.tags(line).each {
			// get the actual tag
			Tag tag = db.tag(it.name, it.value);
			// make new link
			currentLinks.add(db.link(tag, position));
		}
		// which links must be deleted - ones that existed but don't exist anumore
		Set deleteLinks = new HashSet(existingLinks);
		deleteLinks.removeAll(currentLinks);
		db.removeLinks(deleteLinks);
		// which links must be added - ones that did not exist before
		//Set addLinks = new HashSet(currentLinks);
		//addLinks.remove(existingLinks);
		//links.addAll(addLinks);
	}
	
	static main(args) {
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Path path = Paths.get("bbp", "apache_jena.txt");
		
		Index index = new Index(root)
		index.process(path)
		
		for (Link l in index.db.links) {
			println l.tag.name
			println l.tag.value
			println l.position.path
			println l.position.line
			println "..."
		}
	}

}
