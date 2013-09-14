package com.chronicweirdo.makeitso.ui.maps;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chronicweirdo.makeitso.StructureUtils;

public class ValuePanel extends JPanel {

	private Object value;
	private List path;
	private MapNavigator navigator;
	
	public ValuePanel(MapNavigator navigator) {
		super(new BorderLayout());
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
		ScrollPane scroll = new ScrollPane();
		JPanel content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		for (Map.Entry<Object, Object> entry: map.entrySet()) {
			content.add(new PathButton(
					StructureUtils.duplicate(path, entry.getKey()),
					entry.getKey().toString(), navigator));
		}
		scroll.add(content);
		this.add(scroll, BorderLayout.CENTER);
	}
}
