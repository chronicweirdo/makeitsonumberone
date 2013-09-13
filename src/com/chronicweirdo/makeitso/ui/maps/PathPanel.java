package com.chronicweirdo.makeitso.ui.maps;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PathPanel extends JPanel {

	//private Map data;
	private List path;
	private List<JButton> pathButtons;
	
	public PathPanel() {
		//super(new GridBagLayout());
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	}
	
	public void update(List path) {
		this.path = path;
		
		// rebuild gui
		GridBagConstraints c = new GridBagConstraints();
        //c.gridwidth = GridBagConstraints.REMAINDER;
		//c.gridheight = GridBagConstraints.REMAINDER;

        //c.fill = GridBagConstraints.BOTH;
        //c.weightx = 1.0;
        //c.weighty = 1.0;
		this.removeAll();
		for (Object object: path) {
			JButton button = new JButton();
			button.setText(object.toString());
			//this.add(button, c);
			this.add(button);
		}
	}
}
