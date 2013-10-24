package com.chronicweirdo.makeitso.patterns

class RegexPatternMatcher {

	static backreferences() {
		String text = "<html><b>bold</b> <i>italic</i></html>";
		
		def matcher = text =~ /(?m)(?s)<(\w+)>(.*?)<\/(\1)>/
		for (match in matcher) {
			println match
		}
	}
	
	static recursiveBackreferences(text) {
		def matcher = text =~ /(?m)(?s)<(\w+)>(.*?)<\/(\1)>/
		for (match in matcher) {
			println match
			recursiveBackreferences(match[2])
		}
	}
	static main(args) {
		//backreferences();
		recursiveBackreferences("<html><b>bold</b> <i>italic</i></html>")
	}

}
