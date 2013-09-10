package com.chronicweirdo.makeitso.console;

public class Text {
	
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
	public static char[][] asMatrix(String text) {
		// split into lines
		String[] lines = text.split("[\n\r]");
		int width = 0;
		for (String line: lines) {
			if (line.length() > width) {
				width = line.length();
			}
		}
		char[][] window = new char[lines.length][width];
		for (int y = 0; y < lines.length; y++) {
			for (int x = 0; x < lines[y].length(); x++) {
				window[y][x] = lines[y].charAt(x);
			}
		}
		return window;
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
				"nisl imperdiet";
		print(asMatrix(text));
		print(window(text, 5, 0, 10, 10));
	}

}
