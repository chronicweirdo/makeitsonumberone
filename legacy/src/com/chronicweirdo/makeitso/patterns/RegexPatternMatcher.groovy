package com.chronicweirdo.makeitso.patterns

class RegexPatternMatcher {

	static backreferences() {
		String text = "<html><b>bold</b> <i>italic</i></html>";
		
		def matcher = text =~ /(?m)(?s)<(\w+)>(.*?)<\/(\1)>/
		for (match in matcher) {
			println match
		}
	}
	
	static class NOD {
		String tag;
		List<NOD> content;
		
		@Override
		public String toString() {
			return "[" + tag + ": " + content.toString() + "]";
		}
	}
	
	static List recursiveBackreferences(text) {
		List result = [];
		def matcher = text =~ /(?m)(?s)<(\w+)>(.*?)<\/(\1)>/
		for (match in matcher) {
			println match
			NOD nod = new NOD();
			nod.tag = match[1];
			nod.content = recursiveBackreferences(match[2])
			result.add(nod)
		}
		return result;
	}
	static main(args) {
		//backreferences();
		println recursiveBackreferences("<html><b>bold</b> <i>italic</i></html>")
	}

}
