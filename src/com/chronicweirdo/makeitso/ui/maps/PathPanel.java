package com.chronicweirdo.makeitso.ui.maps;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import com.chronicweirdo.makeitso.StructureUtils;

public class PathPanel extends JPanel {

	//private Map data;
	private List path;
	private List<PathButton> pathButtons;
	private MapNavigator navigator;
	private boolean initialized = false;
	
	public PathPanel(MapNavigator navigator) {
		//super(new GridBagLayout());
		//setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		//setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		setLayout(new GridLayout(0, 5));
		this.navigator = navigator;
		this.path = StructureUtils.list();
		this.add(new PathButton(path, "/", navigator));
	}
	
	@Override
	public void revalidate() {
		super.revalidate();
		resize();
	}
	
	public void resize() {
		/*if (initialized) {
			System.out.println("resizing");
			int height = 0;
			for (Component component: this.getComponents()) {
				int tHeight = component.getBounds().y + component.getBounds().height;
				if (height < tHeight) height = tHeight;
			}
			Dimension prefferedSize = new Dimension((int) this.getPreferredSize().getWidth(), height);
			System.out.println(prefferedSize);
			this.setPreferredSize(prefferedSize);
		}*/
		System.out.println(this.getSize());
	}
	
	public void setPath(List path) {
		this.path = path;
		this.removeAll();
		List list = StructureUtils.list();
		{
			this.add(new PathButton(list, "/", navigator));
		}
		for (Object object: path) {
			list = StructureUtils.duplicate(list, object);
			this.add(new PathButton(list, object.toString(), navigator));
		}
		this.initialized = true;
		//this.updateUI();
		//this.resize();
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
		
	}
}
