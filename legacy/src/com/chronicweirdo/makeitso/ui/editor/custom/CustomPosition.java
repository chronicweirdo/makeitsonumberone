package com.chronicweirdo.makeitso.ui.editor.custom;

import javax.swing.text.Position;

public class CustomPosition implements Position {

	private int offset;
	
	public CustomPosition(int offset) {
		this.offset = offset;
	}
	
	@Override
	public int getOffset() {
		return this.offset;
	}

}
