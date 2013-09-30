package com.chronicweirdo.makeitso.ui.editor;

import java.awt.Color;
import java.awt.Font;

import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class SourceStyledDocument extends AbstractDocument implements StyledDocument {

	protected SourceStyledDocument(Content data) {
		super(data);
	}

	@Override
	public Style addStyle(String arg0, Style arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getCharacterElement(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Font getFont(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getForeground(AttributeSet arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Style getLogicalStyle(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Style getStyle(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeStyle(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCharacterAttributes(int arg0, int arg1, AttributeSet arg2,
			boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLogicalStyle(int arg0, Style arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setParagraphAttributes(int arg0, int arg1, AttributeSet arg2,
			boolean arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Element getDefaultRootElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getParagraphElement(int pos) {
		// TODO Auto-generated method stub
		return null;
	}


}
