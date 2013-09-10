package com.chronicweirdo.makeitso;

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
	
	public static class TextTransformation {
		public int x(int x) {
			return 0;
		}
		public int y(int y) {
			return 0;
		}
	}
	
	public static interface Text {
		void set(int x, int y, char c);
		char get(int x, int y);
		void insert(int x, int y, char c);		
		void delete(int x, int y);
	}
	public static class OriginalText implements Text {
		private List<List<Character>> data;
		
		public void set(int x, int y, char c) {
			data.get(y).set(x, c);
		}

		public char get(int x, int y) {
			return data.get(y).get(x);
		}

		public void insert(int x, int y, char c) {
			data.get(y).add(x, c);
		}

		public void delete(int x, int y) {
			data.get(y).remove(x);
			if (data.get(y).size() == 0) {
				data.remove(y);
			}
		}
		
	}
	public static class SourcedText implements Text {
		Text source;
		TextTransformation toSource;

		public void set(int x, int y, char c) {
			
		}
		public char get(int x, int y){
			return '.';
		}
		public void insert(int x, int y, char c) {
			
		}
		public void delete(int x, int y) {
			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
