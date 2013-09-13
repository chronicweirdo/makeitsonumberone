package com.chronicweirdo.makeitso.ui.maps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class MapSingleScreen extends JPanel {
	
	private PathPanel pathPanel;
	private JPanel valuePanel;
	
	public MapSingleScreen() {
		//super(new GridBagLayout());
		super(new BorderLayout());

		pathPanel = new PathPanel();
		pathPanel.setBackground(Color.green);
		List path = new ArrayList();
		path.add("accounts");
		path.add("facebook");
		path.add("username");
		path.add("password");
		path.add("first_character");
		path.add("nothing");
		pathPanel.update(path);
		
		valuePanel = new JPanel();
		valuePanel.setBackground(Color.red);
		valuePanel.add(new JLabel("value panel"));
        
        //Add Components to this panel.
        //GridBagConstraints c = new GridBagConstraints();
        //c.gridwidth = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 1.0;
        //add(pathPanel, c);
        add(pathPanel, BorderLayout.NORTH);
        
        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 3.0;
        //add(valuePanel, c);
        add(valuePanel, BorderLayout.CENTER);
	}
	
	private static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		
        //Create and set up the window.
        JFrame frame = new JFrame("ConsoleDemo");
        frame.setSize(new Dimension(500, 800));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new MapSingleScreen());

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
