package com.chronicweirdo.makeitso.console;

import java.util.ArrayList;
import java.util.List;

public class TextTest6 {
	
	public static class Canvas {
		List<List<Character>> data;
		Integer wrap;
		
		public Canvas(String text, Integer wrap) {
			// split by lines
			this.wrap = wrap;
			data = wrap(split(text), wrap);
		}
		private static List<List<Character>> wrap(List<List<Character>> datain, Integer wrap) {
			List<List<Character>> dataout = new ArrayList<List<Character>>();
			for (List<Character> line: datain) {
				dataout.addAll(wrapLine(line, wrap));
			}
			return dataout;
		}
		private static List<List<Character>> wrapLine(List<Character> line, Integer wrap) {
			List<List<Character>> dataout = new ArrayList<List<Character>>();
			if (wrap != null) {
				int i = 0;
				while (i < line.size()) {
					if (i + wrap < line.size()) {
						dataout.add(line.subList(i, i + wrap));
					} else {
						dataout.add(line.subList(i, line.size()));
					}
					i += wrap;
				}
			} else {
				dataout.add(line);
			}
			return dataout;
		}
		private static List<List<Character>> split(String text) {
			List<List<Character>> data = new ArrayList<List<Character>>();
			List<Character> line = new ArrayList<Character>();
			for (Character c: text.toCharArray()) {
				line.add(c);
				if (c.equals('\n')) {
					data.add(line);
					line = new ArrayList<Character>();
				} 
			}
			if (line.size() > 0) {
				data.add(line);
			}
			return data;
		}
		public void print() {
			for (List<Character> line: data) {
				for (Character c: line) {
					System.out.print(c);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) {
		String text = "line one\n" +
				  "second line";
		Canvas c = new Canvas(text, null);
		c.print();
		Canvas d = new Canvas(text, 5);
		d.print();
	}

}
