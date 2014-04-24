package com.chronicweirdo.makeitso.console;

import java.awt.Point;

public class TextTest5 {

	public static class Char {
		Character c;
		Char p;
		Char n;
		boolean breakChar;
		
		Char previous(Character c) {
			Char x = this;
			while (x != null && !x.c.equals(c)) {
				x = x.p;
			}
			return x;
		}
		Char next(Character c) {
			Char x = this;
			while (x != null && !x.c.equals(c)) {
				x = x.n;
			}
			return x;
		}
		Char jump(Integer jump) {
			Char x = this;
			int oJump = jump;
			while (jump != 0 && x != null) {
				if (jump < 0) {
					// we jump backward
					jump++;
					x = x.p;
				} else {
					// we jump forward
					jump--;
					x = x.n;
				}
			}
			return x;
		}
	}
	public static class Group {
		Char first;
		Char last;
		Group p;
		Group n;
	}
	public static Group makeLines(Char s) {
		Group first = null;
		Group g = null;
		Group p = null;
		while (s != null) {
			if (g == null) {
				g = new Group();
				g.first = s;
				if (first == null) {
					first = g;
				}
			}
			if (s.c.equals('\n')) {
				// new group
				g.last = s;
				g.p = p;
				if (p != null) {
					p.n = g;
				}
				p = g;
				g = null;
			}
			s = s.n;
		}
		return first;
	}
	
	public static Point wrappedPosition(Char first, Char current, int wrap) {
		int x = 0;
		int y = 0;
		
		return new Point(x, y);
	}
	public static Char toChar(String string) {
		Char first = null;
		Char previous = null;
		for (Character character: string.toCharArray()) {
			Char c = new Char();
			c.c = character;
			// create previous link
			c.p = previous;
			if (previous != null) {
				previous.n = c;
			}
			previous = c;
			if (first == null) {
				first = c;
			}
		}
		return first;
	}

	public static void print(Char c) {
		while (c != null) {
			System.out.print(c.c);
			c = c.n;
		}
		System.out.println();
	}
	public static void print(Group g) {
		int i = 0;
		while (g != null) {
			System.out.print(i + ": ");
			Char c = g.first;
			while (c != g.last) {
				System.out.print(c.c);
				c = c.n;
			}
			System.out.println();
			g = g.n;
			i++;
		}
	}
	public static void main(String[] args) {
		String text = "line one\n" +
				  "second line";
		Char c = toChar(text);
		print(c);
		Char x = c.jump(5);
		System.out.println(x.c);
		x = x.jump(-2);
		System.out.println(x.c);
		// getting the first char in the next line
		x = x.next('\n').jump(1);
		System.out.println(x.c);
		// getting the first char of the next word
		x = x.next(' ').jump(1);
		System.out.println(x.c);
		
		// find position of character x in wrapped text
		int wrap = 5;
		
		
		print(makeLines(c));
	}

}
