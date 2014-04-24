package com.chronicweirdo.makeitso.file.index

import java.nio.file.Path
import java.nio.file.Paths

/**
 * We need a general index "director" that can handle all indexing functionality for a group of
 * files.
 * 
 * 1. The index is always based on a "root" location (folder).
 * 2. Have functionality to convert existing index to a different root.
 * 3. Merging of indexes, based on 2.
 * 4. Support pluggable processors - each processor creates data for a different index.
 * 5. Support pluggable accessors, that allow opening files based based on index data - one
 * accessor for each index.
 * 6. An API + CLI (command line interface).
 * 7. Index from file to each indexing data we have.
 * 8. Support for checking and rebuilding of index for new files and changed and deleted files.
 * 
 * @author cacovean
 *
 */
class Principal {

	Path root;
	
	Map<String, Index> indexes = new HashMap();
	Map<Path, Date> indexed = new HashMap();
	
	File file(Path path) {
		if (path) return new File(root.resolve(path).toString());
		return new File(root.toString());
	}
	
	/**
	 * For each file in the root folder:
	 * 	- if the file has changed since the last indexing, update the indexes
	 *  - if the file is not in the indexed list, the file does not exist and we must add it
	 *  - if none of the above, just update the indexed date
	 * At the end, all files whose indexed date was not updated must be deleted since they no
	 * longer exist
	 */
	void index() {
		Date now = new Date();
		// build/update index
		index(now, null);
		// clean index
		clean(now);
	}
	void clean(Date now) {
		
	}
	
	void index(Date now, Path current) {
		println "processing $current"
		File file = file(current);
		if (file.isDirectory()) {
			file.list().each{
				if (current) index(now, Paths.get(current.toString(), it));
				else index(now, Paths.get(it));
			}
		} else {
			// add file to indexes
			Date old = indexed[current];
			if (old) {
				// check if file has been updated since old index
				if (old.time < file.lastModified()) {
					// update the index
					reindex(current);
					// update the date
					indexed[current] = now;
				} else {
					// index is still valid
					indexed[current] = now;
				}
			} else {
				// new file add to index
				reindex(current);
				// update the date
				indexed[current] = now;
			}
		}
	}
	
	void reindex(Path current) {
		for (Index index: indexes.values()) {
			index.process(current);
		}
	}
	
	static main(args) {
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Principal principal = new Principal(root: root)
		principal.indexes["tag"] = new BasicIndex();
		principal.indexes["tag"].processor = new TagProcessor(root);
		principal.index();
		println principal.indexes["tag"].data
		//println principal.terms;
		println principal.indexes["tag"].terms["tag"]["writing"]
		/*
		 * The problem now is that we get a file+line where a tag was found. This is great if we
		 * are looking for the line that contains #code #writing and #tech, but if we want the file
		 * containing all those lines, we won't get what we want.
		 */
		Set a = new HashSet(principal.indexes["tag"].terms["tag"]["overview"])
		Set b = new HashSet(principal.indexes["tag"].terms["tag"]["jena"])
		Set c = new HashSet(principal.indexes["tag"].terms["tag"]["code"])
		println a
		println b
		a.retainAll(b)
		println a
		a.retainAll(c)
		println a
		/*
		 * Maybe should only keep the tag and value as search terms!
		 */
		Set d = new HashSet(principal.indexes["tag"].terms["tag"]["tech"])
		Set e = new HashSet(principal.indexes["tag"].terms["value"]["xtext"])
		println "d: $d"
		println "e: $e"
		d.retainAll(e);
		println "d final: $d"
	}
}
