package com.chronicweirdo.makeitso.console;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridTextAreaTest extends JPanel {
	
	private double characterWidth = 20d;
	private double characterHeight = 30d;
	
	private JEditorPane text;
	
	public GridTextAreaTest() {
		init();
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				init();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void init() {
		System.out.println("initializing");
		int width = new Double(Math.floor(getWidth() / characterWidth)).intValue();
		int height = new Double(Math.floor(getHeight() / characterHeight)).intValue();
		this.removeAll();
		this.setLayout(new GridLayout(1, 1));
		text = new JEditorPane();
		text.setFont(new Font("monospaced", Font.PLAIN, 20));
		text.setEditable(false);
		text.setText("this is a test");
		this.add(text);
	}

	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridConsoleDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        GridTextAreaTest panel = new GridTextAreaTest();
        panel.setSize(500, 200);
        frame.add(panel);

        //Display the window.
        frame.pack();
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
