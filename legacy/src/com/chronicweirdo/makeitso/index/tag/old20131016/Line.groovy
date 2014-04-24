package com.chronicweirdo.makeitso.index.tag.old20131016

import java.nio.file.Path
import java.nio.file.Paths

import com.chronicweirdo.makeitso.file.FileUtils

class Line {

	String text;
	String file;
	int line;
	int offset;
	
	static List<Line> lines(Path root, Path file) {
		Path full = root.resolve(file);
		
		String contents = FileUtils.readTextFile(full.toString());
		String[] lines = contents.split("[\n\r]");
		List<Line> result = new ArrayList<Line>();
		int offset = 0;
		int lineNum = 0;
		lines.each{
			Line l = new Line();
			l.text = it;
			l.offset = offset;
			l.line = lineNum;
			l.file = file;
			result.add(l);
			
			offset += it.length();
			lineNum += 1;
		}
		return result;
	}
	
	static main(args) {
		//Path root = Paths.get("/Users/cacovean/Dropbox/mydata/wiki");
		Path root = Paths.get(System.getProperty("user.home"), "Dropbox", "mydata", "wiki");
		Path path = Paths.get("bbp", "apache_jena.txt");
		
		List<Line> lines = lines(root, path);
		lines.each {
			println "$it.line,$it.offset: $it.text";
		}
	}

}
