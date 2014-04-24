package com.chronicweirdo.makeitso.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

/**
 * Static methods used to wrap a component in a windows and show the window.
 * @author Silviu
 *
 */
public class Wrapper {

	public static void wrapSpringLayout(String title, JComponent component) {
		// Create and set up the window.
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(component.getBackground());
		
		SpringLayout layout = new SpringLayout();
		frame.getContentPane().setLayout(layout);
		
		frame.getContentPane().add(component);
		layout.putConstraint(SpringLayout.NORTH, component, 5, 
				SpringLayout.NORTH, frame.getContentPane());
		layout.putConstraint(SpringLayout.WEST, component, 5, SpringLayout.WEST,
				frame.getContentPane());
		layout.putConstraint(SpringLayout.EAST, frame.getContentPane(), 5,
				SpringLayout.EAST, component);
		layout.putConstraint(SpringLayout.SOUTH, frame.getContentPane(), 5,
				SpringLayout.SOUTH, component);
		
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void wrapBorderLayout(String title, JComponent component) {
		// Create and set up the window.
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setBackground(component.getBackground());
		
		BorderLayout layout = new BorderLayout();
		frame.getContentPane().setLayout(layout);
		
		frame.getContentPane().add(BorderLayout.CENTER, component);
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void wrap(String title, JComponent component) {
		// Create and set up the window.
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().setBackground(component.getBackground());
		
		frame.getContentPane().add(component);
		
		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		String title = "UITest";
		JLabel label = new JLabel("Hello World");
		wrapSpringLayout(title, label);
	}

}
