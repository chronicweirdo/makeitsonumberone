package com.chronicweirdo.makeitso.console;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JEditorPane;

public class GraphicsTextAreaTest extends Canvas {
	
	private double characterWidth = 20d;
	private double characterHeight = 30d;
	
	private JEditorPane text;
	
	public GraphicsTextAreaTest() {
	}
	
	public void paint(Graphics g) {
		g.drawRect(100, 100, 80, 80);
		g.drawString("abc", 25, 25);
	}

	private static void createAndShowGUI() {
		Canvas canvas = new GraphicsTextAreaTest();
		//canvas.setSize(120,120);
		canvas.setBackground(Color.RED);
		
		Frame frame = new Frame();
		frame.add(canvas);
		//frame.setLayout(new FlowLayout());
		frame.setSize(250,250);
		frame.setVisible(true);
    }
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
