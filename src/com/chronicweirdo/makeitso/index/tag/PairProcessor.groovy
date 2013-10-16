package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path;


import com.chronicweirdo.makeitso.path.FileProcessor

class PairProcessor implements FileProcessor<List<Pair>> {

	private boolean accept(Path path) {
		return path.toString().endsWith(".txt");
	}
	
	@Override
	public List<Pair> processFile(Path root, Path relative) {
		if (!accept(relative)) return null;
		File file = root.resolve(relative).toFile();
		int num = 1;
		List<Pair> result = new ArrayList();
		file.eachLine { line ->
			Position position = new Position();
			position.path = relative;
			position.line = num;
			List<Tag> tags = getTagsInLine(line);
			tags.each {
				Pair pair = new Pair(tag: it, position: position);
				result.add(pair);
			}
			num++;
		}
		return result;
	}

	private List<Tag> getTagsInLine(String line) {
		List<Tag> result = new ArrayList<Tag>();
		def tagMatcher = line =~ /#[a-zA-Z][\w.]*([:][\w.]+)*/
		for (tagMatch in tagMatcher) {
			Tag tag = new Tag()
			def valueMatcher = tagMatch[0] =~ /[\w.]+/
			for (valueMatch in valueMatcher) {
				tag.values.add(valueMatch);
			}
			result.add(tag);
		}
		return result
	}
	
	static main(args) {
		String line = "#tech #tech:now #tech:now:firstpage #date:2013.10.16:14.28";
		def tagMatcher = line =~ /#[a-zA-Z][\w.]*([:][\w.]+)*/
		for (tagMatch in tagMatcher) {
			//println tagMatch[0];
			Tag tag = new Tag()
			def valueMatcher = tagMatch[0] =~ /[\w.]+/
			for (valueMatch in valueMatcher) {
				//println valueMatch
				tag.values.add(valueMatch);
			}
			println tag;
		}
	}
}
