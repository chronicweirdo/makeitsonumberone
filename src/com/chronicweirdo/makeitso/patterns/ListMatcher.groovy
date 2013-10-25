package com.chronicweirdo.makeitso.patterns

class ListMatcher {
	
	private static boolean test = false;

	static class RegexListMatcher {
		String regex;
		
		private RegexListMatcher() {};
		
		@Override
		public String toString() {
			return "RM: $regex";
		}
	}
	
	static class JumpListMatcher {
		Integer min;
		Integer max;
		
		private JumpListMatcher() {}
		
		@Override
		public String toString() {
			return "JM: $min - $max";
		}
	}
	
	static boolean matches(list, matcherList) {
		return runMatch(list, 0, matcherList, 0);
	}
	
	private static boolean runMatch(list, listIndex, matcher, matcherIndex) {
		if (test) println listIndex + " " + list.size() + " " + matcherIndex + " " + matcher.size()
		if (listIndex == list.size() && matcherIndex == matcher.size()) {
			if (test) println "we reached the end of both lists"
			return true;
		}
		if (test) println "matching " + list[listIndex] + " with " + matcher[matcherIndex]
		def currentMatcher = matcher[matcherIndex]
		if (currentMatcher instanceof RegexListMatcher) {
			if (!(list[listIndex] =~ currentMatcher.regex)) return false
			// if it matches, we continue
			return runMatch(list, listIndex+1, matcher, matcherIndex+1);
		}
		if (currentMatcher instanceof JumpListMatcher) {
			def currentListIndex = listIndex
			if (currentMatcher.min) {
				// automatically jump the minimum number of jumps allowed
				currentListIndex += currentMatcher.min
			}
			if (test) println "current index: " + currentListIndex
			
			while (currentListIndex <= list.size() && ((currentMatcher.max == null) || (currentListIndex <= listIndex + currentMatcher.max))) {
				if (test && currentListIndex > listIndex) println "engulfing " + list[currentListIndex-1]
				if (runMatch(list, currentListIndex, matcher, matcherIndex+1)) return true;
				if (test) println "must engulf more"
				currentListIndex++;
			}
		}
		return false;
	}
	
	static RegexListMatcher r(String reg) {
		return regex(reg)
	}
	static RegexListMatcher regex(String regex) {
		return new RegexListMatcher(regex: regex);
	}
	
	static JumpListMatcher j() {
		return jump()
	}
	static JumpListMatcher jump() {
		return new JumpListMatcher();
	}
	
	static JumpListMatcher j(int min, int max) {
		return jump(min, max)
	}
	static JumpListMatcher jump(int min, int max) {
		return new JumpListMatcher(min: min, max: max);
	}

	static JumpListMatcher jm(int min) {
		return jumpMin( min);
	}
	static JumpListMatcher jumpMin(int min) {
		return new JumpListMatcher(min: min);
	}
	
	static JumpListMatcher jx(int max) {
		return jumpMax(max);
	}
	static JumpListMatcher jM(int max) {
		return jumpMax(max);
	}
	static JumpListMatcher jumpMax(int max) {
		return new JumpListMatcher(max: max);
	}
	
	static main(args) {
		ListMatcher m = new ListMatcher();
		println m.matches(
			["one", "token", "of", "my", "appreciation"],
			[m.j(), m.r("token"), m.jm(1), m.r("app.*"), m.j()]
			) // true
		println m.matches(
			["one", "token", "of", "my", "appreciation"],
			[m.j(), m.r("token"), m.jm(3), m.r("app.*"), m.j()]
			) // false
	}

}
