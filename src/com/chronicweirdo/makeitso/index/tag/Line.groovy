package com.chronicweirdo.makeitso.index.tag

import java.io.File;

import com.chronicweirdo.makeitso.file.FileUtils;

class Line {

	String text;
	String file;
	int line;
	int offset;
	
	static List<Line> lines(String file) {
		String contents = FileUtils.readTextFile(new File(file).getAbsolutePath());
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
		String path = 'C:\\Users\\Silviu\\Dropbox\\mydata\\wiki\\todo_tech.txt';
		List<Line> lines = lines(path);
		lines.each {
			print "$it.line,$it.offset: $it.text\n";
		}
	}

}
