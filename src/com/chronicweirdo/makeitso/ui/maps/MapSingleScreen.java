package com.chronicweirdo.makeitso.ui.maps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.chronicweirdo.makeitso.Struct;

public class MapSingleScreen extends JPanel implements MapNavigator {
	
	private PathPanel pathPanel;
	private ValuePanel valuePanel;
	private Object data;
	private List path;
	
	@Override
	public void setData(Object data) {
		this.data = data;
		// set path to null
		this.path = new ArrayList();
		pathPanel.setPath(this.path);
		// display base object
		valuePanel.setValue(this.path, this.data);
	}
	
	@Override
	public void setPath(List path) {
		// set path
		this.path = path;
		pathPanel.setPath(this.path);
		// display object
		Object value = Struct.get(data, path);
		System.out.println(value.toString());
		valuePanel.setValue(this.path, value);
		//pathPanel.revalidate();
		revalidate();
	}
	
	public MapSingleScreen() {
		super(new GridBagLayout());
		//super(new BorderLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		//c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		pathPanel = new PathPanel(this);
		//pathPanel.setPreferredSize(new Dimension(500, 32));
		pathPanel.setBackground(Color.green);
		List path = new ArrayList();
		path.add("accounts");
		path.add("facebook");
		path.add("username");
		path.add("password");
		path.add("first_character");
		path.add("nothing");
		pathPanel.update(path);
		
		//add(pathPanel, BorderLayout.NORTH);
		add(pathPanel, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1;
		//c.weighty = 5;
		c.fill = GridBagConstraints.BOTH;
		valuePanel = new ValuePanel(this);
		valuePanel.setBackground(Color.red);
		
		//add(valuePanel, BorderLayout.CENTER);
		add(valuePanel, c);
        
        //Add Components to this panel.
        //GridBagConstraints c = new GridBagConstraints();
        //c.gridwidth = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 1.0;
        //add(pathPanel, c);
        
        
        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 3.0;
        //add(valuePanel, c);
        
        
        addComponentListener(new ComponentListener() {

			@Override
			public void componentResized(ComponentEvent e) {
				MapSingleScreen.this.pathPanel.resize();
			}

			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
	}
	
	private static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		
        //Create and set up the window.
        JFrame frame = new JFrame("ConsoleDemo");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        MapSingleScreen mss = new MapSingleScreen();
        mss.setPreferredSize(new Dimension(500, 500));
        frame.setLayout(new BorderLayout());
        frame.add(mss, BorderLayout.CENTER);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        // initial data
        Map map = new HashMap();
        Struct.set(map, Struct.list("folder1", "subfolder1", "file1"), 1);
        Struct.set(map, Struct.list("folder1", "subfolder1", "file2"), 2);
        Struct.set(map, Struct.list("folder1", "subfolder2", "file3"), 3);
        Struct.set(map, Struct.list("folder2", "subfolder3", "file4"), 4);
        Struct.set(map, Struct.list("folder2", "file5"), 5);
        Struct.set(map, Struct.list("folder2", "file6"), 5);
        Struct.set(map, Struct.list("folder2", "file7"), 5);
        Struct.set(map, Struct.list("folder2", "file8"), 5);
        Struct.set(map, Struct.list("folder2", "file9"), 5);
        Struct.set(map, Struct.list("folder2", "file10"), 5);
        Struct.set(map, Struct.list("folder2", "file11"), 5);
        Struct.set(map, Struct.list("folder2", "file12"), 5);
        Struct.set(map, Struct.list("folder2", "file13"), 5);
        Struct.set(map, Struct.list("folder2", "file14"), 5);
        Struct.set(map, Struct.list("folder2", "file15"), 5);
        Struct.set(map, Struct.list("folder2", "file16"), 5);
        Struct.set(map, Struct.list("folder2", "file17"), 5);
        Struct.set(map, Struct.list("folder2", "file18"), 5);
        Struct.set(map, Struct.list("folder2", "file19"), 5);
        Struct.set(map, Struct.list("folder2", "file20"), 5);
        Struct.set(map, Struct.list("folder2", "file21"), 5);
        Struct.set(map, Struct.list("folder2", "file22"), 5);
        Struct.set(map, Struct.list("folder2", "file23"), 5);
        Struct.set(map, Struct.list("folder2", "file24"), 5);
        Struct.set(map, Struct.list("folder2", "file25"), 5);
        Struct.set(map, Struct.list("folder2", "file26"), 5);
        Struct.set(map, Struct.list("folder2", "file27"), 5);
        Struct.set(map, Struct.list("folder2", "file28"), 5);
        Struct.set(map, Struct.list("folder2", "file29"), 5);
        Struct.set(map, Struct.list("folder2", "file30"), 5);
        Struct.set(map, Struct.list("deep", "deep", "deep", "deep", "deep", "deep", "deep", "deep", "deep"), "deep");
        mss.setData(map);
        mss.setPath(Struct.list("folder1"));
    }

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
