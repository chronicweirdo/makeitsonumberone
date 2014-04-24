package com.chronicweirdo.makeitso.ui.maps;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;

public class PathButton extends JButton {

	private List path;
	private MapNavigator navigator;
	
	public PathButton(List path, String label, MapNavigator navigator) {
		super(label);
		this.navigator = navigator;
		this.path = path;
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicked");
				PathButton.this.navigator.setPath(PathButton.this.path);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public List getPath() {
		return path;
	}
}
