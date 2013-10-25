package com.chronicweirdo.makeitso.patterns

class ListMatcherTest {
	
	static boolean test = false;
	
	static class RM {
		String regex;
		@Override
		public String toString() {
			return "RM: $regex";
		}
	}
	
	static class JM {
		Integer min;
		Integer max;
		public String toString() {
			return "JM: $min - $max";
		}
	}
	
	static boolean matches(list, listIndex, matcher, matcherIndex) {
		if (test) println listIndex + " " + list.size() + " " + matcherIndex + " " + matcher.size()
		if (listIndex == list.size() && matcherIndex == matcher.size()) {
			if (test) println "we reached the end of both lists"
			return true;
		}
		if (test) println "matching " + list[listIndex] + " with " + matcher[matcherIndex]
		def currentMatcher = matcher[matcherIndex]
		if (currentMatcher instanceof RM) {
			if (!(list[listIndex] =~ currentMatcher.regex)) return false 
			// if it matches, we continue
			return matches(list, listIndex+1, matcher, matcherIndex+1);
		}
		if (currentMatcher instanceof JM) {
			def currentListIndex = listIndex
			if (currentMatcher.min) {
				// automatically jump the minimum number of jumps allowed
				currentListIndex += currentMatcher.min
			} else {
				// try to skip matcher altogether, since no minimum limit
				if (test) println "skipping matcher"
				if (matches(list, currentListIndex, matcher, matcherIndex+1)) return true;
			}
			if (test) println "current index: " + currentListIndex
			
			while (currentListIndex < list.size() && ((currentMatcher.max == null) || (currentListIndex < listIndex + currentMatcher.max))) {
				if (test) println "engulfing " + list[currentListIndex]
				if (matches(list, currentListIndex+1, matcher, matcherIndex+1)) return true;
				if (test) println "must engulf more"
				currentListIndex++;
			}
		}
		return false;
	}

	static main(args) {
		//def list1 = ["a", "small", "token", "of", "my", "appreciation"]
		//def mat = [new JM(max:2), new RM(regex: "token"), new JM()]
		//println matches(list1, 0, mat, 0)
		/*println matches(
			["a", "small", "token", "of", "my", "appreciation"], 0,
			[new JM(max:2), new RM(regex: "token"), new JM()], 0
			) // true
		println matches(
				["a", "small", "token", "of", "my", "appreciation"], 0,
				[new JM(max:2), new RM(regex: "token"), new JM(max:2)], 0
				) // false, last jump matcher
		println matches(
				["a", "small", "token", "of", "my", "appreciation"], 0,
				[new JM(max:2), new RM(regex: "token"), new JM(max:3)], 0
				) // true
		*/
		test = true;		
		/*println matches(
				["token", "of", "my", "appreciation"], 0,
				[new JM(max:2), new RM(regex: "token"), new JM(max:3)], 0
				) // true
		println matches(
				["token", "of", "my", "appreciation"], 0,
				[new JM(min: 1, max:2), new RM(regex: "token"), new JM(max:3)], 0
				)*/ // false, first jump match has min
		println matches(
				["one", "token", "of", "my", "appreciation"], 0,
				[new JM(min: 1, max:2), new RM(regex: "token"), new JM(max:3)], 0
				) // true
	}

}
