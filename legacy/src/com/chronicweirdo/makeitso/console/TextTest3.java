package com.chronicweirdo.makeitso.console;

import java.awt.Point;
import java.util.List;

public class TextTest3 {
	
	public static class Char {
		Character c;
		Point p;
	}
	
	public static interface Text {
		Character get(Point p);
		Point getPrevious(Point p);
		Integer lineSize(Integer line);
	}
	
	public static class OriginalText implements Text {
		List<Character> data;
		
		public Character get(Point p) {
			if (p.y < 0 || p.y > 0) return null;
			if (p.x < 0 || p.x > data.size()) return null;
			return data.get(p.x);
		}
		
		public Integer lineSize(Integer line) {
			if (line != 0) return null;
			return data.size();
		}
		
		public Point getPrevious(Point p) {
			if (p.y < 0 || p.y > 0) return null;
			if (p.x == 0) return null;
			return new Point(p.x-1, p.y);
		}
	}
	
	/*public static class LinedText implements Text {
		List<List<Character>> data;
		
		public Character get(Point p) {
			if (p.y < 0 || p.y > data.size()) return null;
			List<Character> d = data.get(p.y);
			if (p.x < 0 || p.x > d.size()) return null;
			return d.get(p.x);
		}
		
		public Point getPrevious(Point p) {
			if (p.y < 0 || p.y > data.size()) return null;
			if (p.x == 0 && p.y == 0) return null;
			if (p.x == 0) return 
		}
	}
	
	public static class WrappedText implements Text {
		List<List<Character>> data;
		int wrap;
		
		public Character get(Point p) {
			if (p.y < 0 || p.y > data.size()) return null;
			List<Character> d = data.get(p.y);
			if (p.x < 0 || p.x > d.size() || p.x > wrap) return null;
			return d.get(p.x);
		}
	}*/
	
	/*public static class WindowedText implements Text {
		List<List<Character>> data;
		
		public Character get(Point p) {
			if (p.y < 0 || p.y > data.size()) return null;
			List<Character> d = data.get(p.y);
			if (p.x < 0 || p.x > d.size()) return null;
			return d.get(p.x);
		}
	}*/
	
	public static interface Transformation {
		Point map(Point p);
		Point inverse(Point p);
	}
	
	/*public static class LinedToOriginalTRansformation implements Transformation {
		public Point map(Point p) {
			//f(x) = sum(characters in all previous lines) + x
			fx = 
			//f(y) = 0
		}
	}*/

	public static void main(String[] args) {

	}

}
