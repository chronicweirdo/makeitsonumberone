package com.chronicweirdo.makeitso.console;

import java.util.ArrayList;
import java.util.List;

public class TextTest4 {

	public static class Text {
		String data;
	}

	public static class Wrapped {
		Integer wrap;
		List<List<Character>> data;

		Character get(int x, int y) {
			if (y < 0 || y > data.size())
				return null;
			List<Character> d = data.get(y);
			if (x < 0 || x > d.size())
				return null;
			return d.get(x);
		}

		void set(int x, int y, Character c) {
			if (y < 0 || y > data.size())
				return;
			List<Character> d = data.get(y);
			if (x < 0 || x > d.size())
				return;
			d.set(x, c);
		}

		void insert(int x, int y, Character c) {
			// go to line
			if (y < 0 || y > data.size())
				return;
			List<Character> d = data.get(y);
			if (c.equals('\n')) {
				// newline char is special
				d.add(x, c);
				// copy characters after to new line
				List<Character> newline = new ArrayList<Character>();
				for (int i = x+1; i < d.size(); i++) {
					
				}
				// delete characters after
			} else {
				// check if we must rewrap
				if (wrap == null) {
					// just add char
					d.add(x, c);
				} else {
					// insert char
					d.add(x, c);
					if (d.size() == wrap) {
						// rewrap
						List<Character> newline = new ArrayList<Character>();
						newline.add(d.get(wrap));
						d.remove(wrap);
						data.add(y + 1, newline);
					}
				}
			}
		}
	}

	public static class Window {
		int x, y, w, h;
		Wrapped wrapped;

		Character get(int x, int y) {
			int wx = this.x + x;
			int wy = this.y + y;
			return wrapped.get(wx, wy);
		}
	}

	public static void main(String[] args) {

	}

}
