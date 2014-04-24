package com.chronicweirdo.makeitso.grammar.wiki;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	private static void find(String text, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(text);
		while (m.find()) {
			System.out.println(m.group());
			for (int g = 0; g < m.groupCount(); g++) {
				System.out.println(g + ": " + m.group(g));
			}
		}
	}
	public static void main(String[] args) {
		String text1 = "This is a text";
		find(text1, "([\\w]+)");

		String link1 = "https://code.google.com/p/mockito/";
		find(link1, "http[\\S]+");
		String link2 = "Look at this link https://code.google.com/p/mockito/ which is beautiful";
		find(link2, "http[\\S]+");
	}

}
