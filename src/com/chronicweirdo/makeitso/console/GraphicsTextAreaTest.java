package com.chronicweirdo.makeitso.console;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JEditorPane;

public class GraphicsTextAreaTest extends Canvas {

	private int characterWidth;
	private int characterHeight;

	private JEditorPane text;

	public GraphicsTextAreaTest() {
	}

	public void paint(Graphics g) {
		Font f = new Font("monospaced", Font.PLAIN, 34);
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		characterHeight = fm.getHeight();
		characterWidth = fm.charWidth('X');
		
		for (int y = 0; y < (this.getHeight() / characterHeight); y++) {
			g.drawLine(0, y*characterHeight, this.getWidth(), y*characterHeight);
		}
		for (int x = 0; x < (this.getWidth() / characterWidth); x++) {
			g.drawLine(x*characterWidth, 0, x*characterWidth, this.getHeight());
		}
		
		//g.drawRect(100, 100, 80, 80);
		//g.drawString("abc", 25, 25);
		//char[] rgc = { 'a' };
		//g.drawChars(rgc, 0, 1, 55, 55);
		String string = "text me!";
		for (int i = 0; i < string.length(); i++) {
			g.drawChars(string.toCharArray(), i, 1, characterWidth*i, characterHeight);
		}
	}

	private static void createAndShowGUI() {
		Canvas canvas = new GraphicsTextAreaTest();
		// canvas.setSize(120,120);
		canvas.setBackground(Color.BLACK);
		canvas.setForeground(Color.GREEN);

		Frame frame = new Frame();
		frame.add(canvas);
		// frame.setLayout(new FlowLayout());
		frame.setSize(250, 250);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
