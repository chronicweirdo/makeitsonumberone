package com.chronicweirdo.makeitso.console;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GridConsoleTest extends JPanel {
	
	private double characterWidth = 20d;
	private double characterHeight = 30d;
	
	//private List<JLabel> grid;
	
	public GridConsoleTest() {
		//init();
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
		this.setLayout(new GridLayout(height, width));
		//grid = new ArrayList<JLabel>();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				JLabel label = new JLabel("x");
				label.setBackground(Color.RED);
				label.setOpaque(true);
				//grid.add(label);
				this.add(label);
			}
		}
	}

	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("GridConsoleDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        GridConsoleTest panel = new GridConsoleTest();
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
