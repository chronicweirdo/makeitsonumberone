package com.chronicweirdo.graph.test

import java.nio.file.Path;

import com.chronicweirdo.makeitso.path.FileProcessor

class LinePairProcessor implements FileProcessor<List<LinePair>> {
	
	public static class LinePair {
		int line;
		List tag
		
		@Override
		public String toString() {
			return "($line :: $tag)"
		}
	}

	private boolean accept(Path path) {
		return path.toString().endsWith(".txt");
	}
	
	@Override
	public List<LinePair> processFile(Path root, Path relative) {
		if (!accept(relative)) return null;
		File file = root.resolve(relative).toFile();
		int num = 1;
		List<LinePair> result = new ArrayList();
		file.eachLine { line ->
			List tags = getTagsInLine(line);
			tags.each {
				LinePair pair = new LinePair(tag: it, line: num);
				result.add(pair);
			}
			num++;
		}
		return result;
	}

	private List getTagsInLine(String line) {
		List result = []
		def tagMatcher = line =~ /#[a-zA-Z][\w.]*([:][\w.]+)*/
		for (tagMatch in tagMatcher) {
			List tag = []
			def valueMatcher = tagMatch[0] =~ /[\w.]+/
			for (valueMatch in valueMatcher) {
				tag.add(valueMatch);
			}
			result.add(tag);
		}
		return result
	}
}
