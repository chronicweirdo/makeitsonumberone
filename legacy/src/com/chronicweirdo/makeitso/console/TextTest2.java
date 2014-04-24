package com.chronicweirdo.makeitso.console;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TextTest2 {

	public static class Char {
		char c;
		int x;
		int y;
		Char source;
		
		public void set(char c) {
			this.c = c;
		}
		public char get() {
			return c;
		}
		public void move(int x, int y) {
			
		}
	}
	
	public static interface TextTransformation {
		Point destination(Point source); // get destination coordonates based on source coordonates
		Point source(Point destination);
	}
	
	public static class SplitByLinesTransformation implements TextTransformation {

		private OriginalText sourceText;
		private Text destinationText;
		
		@Override
		public Point destination(Point source) {
			int fi = source.x;
			// count the number of new lines and distance from new line
			int x = -1;
			int y = 0;
			int i = 0;
			while (i < fi) {
				if (sourceText.get(new Point(i, 0)).equals('\n')) {
					y++;
					x = -1;
				}
				x++;
				i++;
			}
			return new Point(x, y);
		}
		
		@Override
		public Point source(Point destination) {
			int y = destination.y;
			int i = 0;
			while (y > 0) {
				if (sourceText.get(new Point(i, 0)).equals('\n')) {
					y--;
				}
				i++;
			}
			// TODO: problem here !!!
			i += destination.x;
			return new Point(i, 0);
		}
	}
	
	public static interface Text {
		void set(Point p, char c);
		Character get(Point p);
		void insert(Point p, char c);		
		void delete(Point p);
		Integer size(int y);
	}
	public static class OriginalText implements Text {
		private List<Character> data;

		public OriginalText(String string) {
			data = new ArrayList<Character>();
			for (Character c: string.toCharArray()) {
				data.add(c);
			}
		}
		
		@Override
		public void set(Point p, char c) {
			// y is ignored
			data.set(p.x, c);
		}

		@Override
		public Character get(Point p) {
			// y is ignored
			if (p.x >= data.size()) return null;
			return data.get(p.x);
		}

		@Override
		public void insert(Point p, char c) {
			// y is ignored
			data.add(p.x, c);
		}

		@Override
		public void delete(Point p) {
			// y is ignored
			data.remove(p.x);
		}
		
		public Integer size(int y) {
			if (y == 0) return data.size();
			return null;
		}
	}
	
	public static class SourcedText implements Text {
		Text source;
		TextTransformation transformation;

		public void set(Point p, char c) {
			source.set(transformation.source(p), c);
		}
		public Character get(Point p){
			return source.get(transformation.source(p));
		}
		public void insert(Point p, char c) {
			source.insert(transformation.source(p), c);
		}
		public void delete(Point p) {
			source.delete(transformation.source(p));
		}
		public Integer size(int y) {
			int size = 0;
			Character c = get(new Point(size, y));
			if (c == null) return null;
			while (c != null) {
				size++;
				c = get(new Point(size, y));
			}
			return size;
		}
	}
	
	public static void main(String[] args) {
		String text = "line one\n" +
					  "second line";
		/*
		 *    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
		 * 00  l  i  n  e     o  n  e \n  s  e  c  o  n  d     l  i  n  e
		 * 
		 *    00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
		 * 00  l  i  n  e     o  n  e \n
		 * 01  s  e  c  o  n  d     l  i  n  e
		 */
		OriginalText original = new OriginalText(text);
		SplitByLinesTransformation transformation = new SplitByLinesTransformation();
		transformation.sourceText = original;
		
		SourcedText sourced = new SourcedText();
		sourced.source = original;
		sourced.transformation = transformation;
		
		
		
		Point originalDestinationPoint = new Point(3, 1);
		Point sourcePoint = transformation.source(originalDestinationPoint);
		System.out.println(original.get(sourcePoint));
		Point destinationPoint = transformation.destination(sourcePoint);
		System.out.println(originalDestinationPoint);
		System.out.println(sourcePoint);
		System.out.println(destinationPoint);
		
		System.out.println();
		
		System.out.println(sourced.size(0));
		System.out.println(sourced.size(1));
		System.out.println(sourced.size(2));
	}

}
