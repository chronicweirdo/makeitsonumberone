package com.chronicweirdo.makeitso.file.index

import java.nio.file.Files
import java.nio.file.Path

import com.chronicweirdo.makeitso.index.tag.old20131016.Position
import com.chronicweirdo.makeitso.index.tag.old20131016.Tag

class TagProcessor implements Processor {

	Path root;
	
	TagProcessor(Path root) {
		this.root = root;
	}
	
	boolean accept(Path path) {
		def matcher = path.getFileName().toString() =~ /[.]([\w.]+)$/
		if (matcher[0] && "txt" == matcher[0][1]) return true;
		return false;
	}
	
	@Override
	public List<IndexData> process(Path path) {
		println "tag process $path"
		if (!accept(path)) return null;
		List r = new ArrayList();
		// get full path of the file
		Path full = root.resolve(path)
		println "full path $full"
		try {
			println "content type: " + Files.probeContentType(full);
		} catch (IOException e) {}
		// open the file
		// process each line
		int num = 0
		new File(full.toString()).eachLine { line -> 
			r.addAll(process(new Position(path, num), line))
			num++
		}
		// close the file
		return r;
	}
	
	List<IndexData> process(Position position, String line) {
		List r = new ArrayList();
		Tag.tags(line).each {
			println "found tag $it"
			r.add(new TagIndexData(it, position))
		}
		return r;
	}
}
