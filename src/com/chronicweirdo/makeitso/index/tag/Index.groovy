package com.chronicweirdo.makeitso.index.tag

import java.io.File;

import com.chronicweirdo.makeitso.file.FileUtils;

class Index {

	Map<String, List<Position>> index = new HashMap<String, List<Position>>();
	
	static search(String path) {
		
	}
	
	static String[] lines(File file) {
		String contents = FileUtils.readTextFile(file.getAbsolutePath());
		String[] lines = contents.split("[\n\r]");
		return lines;
	}
	
	static main(args) {
	
	}

}
