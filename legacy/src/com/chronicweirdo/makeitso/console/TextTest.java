package com.chronicweirdo.makeitso.console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextTest {
	
	private static final char NEW_LINE = '◖';
	private static final char CARRIAGE_RETURN = '◗';

	public static void print(char[][] window) {
		for (int y = 0; y < window.length; y++) {
			for (int x = 0; x < window[y].length; x++) {
				char c = window[y][x];
				if (c == '\n') {
					System.out.print(NEW_LINE);
				} else if (c == '\r') {
					System.out.print(CARRIAGE_RETURN);
				} else {
					System.out.print(c);;
				}
			}
			System.out.println();
		}
	}
	
	public static List<String> lines(String text) {
		Pattern stuff = Pattern.compile(".*[\n\r]*");
		Matcher matcher = stuff.matcher(text);
		List<String> lines = new ArrayList<String>();
		while (matcher.find()) {
			String mg = matcher.group();
			if (mg.length() > 0) {
				lines.add(mg);
			}
		}
		return lines;
	}
	
	public static char[][] asMatrix(String text) {
		// split into lines
		List<String> lines = lines(text);
		char[][] window = new char[lines.size()][];
		for (int y = 0; y < lines.size(); y++) {
			window[y] = new char[lines.get(y).length()];
			for (int x = 0; x < lines.get(y).length(); x++) {
				window[y][x] = lines.get(y).charAt(x);
			}
		}
		return window;
	}
	
	private static List<List<Character>> wrap(char[] line, int width) {
		List<List<Character>> wrap = new ArrayList<List<Character>>();
		for (int i = 0; i < line.length; i++) {
			if (i % width == 0) {
				wrap.add(new ArrayList<Character>());
			}
			wrap.get(wrap.size()-1).add(line[i]);
		}
		return wrap;
	}
	public static char[][] wrap(char[][] text, int width) {
		List<List<Character>> wrap = new ArrayList<List<Character>>();
		for (int i = 0; i < text.length; i++) {
			wrap.addAll(wrap(text[i], width));
		}
		char[][] result = new char[wrap.size()][width];
		for (int y = 0; y < wrap.size(); y++) {
			for (int x = 0; x < wrap.get(y).size(); x++) {
				result[y][x] = wrap.get(y).get(x);
			}
		}
		return result;
	}

	public static char[][] window(String text, int x, int y, int width,
			int height) {
		char[][] window = new char[height][width];
		char[][] original = asMatrix(text);
		for (int iy = y; iy < height && iy < original.length; iy++) {
			for (int ix = x; ix < width && ix < original[iy].length; ix++) {
				window[iy-y][ix-x] = original[iy][ix];
			}
		}
		return window;
	}
	
	/*
	 * Coordonates are transformed like this:
	 * 		When no wrap is involved:
	 * 			text coordonates <-> window coordonates
	 * 		When wrap is involved:
	 * 			text coordonates <-> wrap coordonates <-> window coordonates
	 */
	
	

	public static void main(String[] args) {
		String text = "Lorem ipsum dolor sit amet, \n" +
				"consectetur adipiscing elit. Donec a diam lectus. Sed sit amet \n" +
				"ipsum mauris. Maecenas \n" +
				"congue \n" +
				"ligula ac quam viverra nec consectetur ante hendrerit. Donec et mollis dolor. \n" +
				"Praesent et diam eget libero egestas mattis sit amet vitae augue. Nam \n" +
				"tincidunt congue enim, ut porta lorem lacinia consectetur. Donec ut libero \n" +
				"sed arcu vehicula ultricies \n" +
				"a non tortor. Lorem ipsum dolor sit amet, consectetur adipiscing \n" +
				"elit. Aenean ut gravida lorem. Ut turpis felis, pulvinar a semper sed, \n" +
				"adipiscing id dolor. Pellentesque auctor nisi id magna consequat sagittis. \n" +
				"Curabitur dapibus enim sit amet elit pharetra tincidunt feugiat \n" +
				"nisl imperdie";
		//print(asMatrix(text));
		print(window(text, 5, 0, 30, 10));
		//Pattern stuff = Pattern.compile("(^.*$)", Pattern.MULTILINE);
		System.out.println("--------------------------------");
		print(wrap(asMatrix(text), 50));
	}

	
}
