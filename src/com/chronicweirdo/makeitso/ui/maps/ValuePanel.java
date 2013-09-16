package com.chronicweirdo.makeitso.ui.maps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chronicweirdo.makeitso.StructureUtils;

public class ValuePanel extends ScrollPane {

	private Object value;
	private List path;
	private MapNavigator navigator;
	
	public ValuePanel(MapNavigator navigator) {
		//super(new BorderLayout());
		//super(new GridLayout(0, 1));
		this.navigator = navigator;
	}
	
	public void setValue(List path, Object value) {
		this.value = value;
		this.path = path;
		if (value instanceof Map) {
			displayMap();
		} else {
			displayObject();
		}
	}
	
	private void displayObject() {
		removeAll();
		add(new JLabel(value.toString()), BorderLayout.CENTER);
	}
	private void displayMap() {
		Map<Object, Object> map = (Map<Object, Object>) value;
		this.removeAll();
		//ScrollPane scroll = new ScrollPane();
		//scroll.setBackground(Color.blue);
		JPanel content = new JPanel();
		content.setBackground(Color.darkGray);
		//content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		//content.setLayout(new GridLayout(0, 1));
		content.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		int i = 0;
		for (Map.Entry<Object, Object> entry: map.entrySet()) {
			c.gridx = 0;
			c.gridy = i;
			c.weightx = 1;
			JButton button = new PathButton(
					StructureUtils.duplicate(path, entry.getKey()),
					entry.getKey().toString(), navigator);
			//button.setPreferredSize(new Dimension(-1, 26));
			content.add(button, c);
			i++;
			
		}
		this.add(content);
		//this.add(scroll, BorderLayout.CENTER);
	}
}
