package com.chronicweirdo.makeitso.ui.editor.custom;

import java.util.Enumeration;

import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;

public class CustomStyle implements Style {
	
	private String name;
	private Style parent;
	
	public CustomStyle(String name, Style parent) {
		this.name = name;
		this.parent = parent;
	}

	@Override
	public void addAttribute(Object arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttributes(AttributeSet arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAttribute(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAttributes(Enumeration<?> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAttributes(AttributeSet arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResolveParent(AttributeSet arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsAttribute(Object name, Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAttributes(AttributeSet attributes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AttributeSet copyAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getAttribute(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttributeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Enumeration<?> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeSet getResolveParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDefined(Object attrName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEqual(AttributeSet attr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addChangeListener(ChangeListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeChangeListener(ChangeListener arg0) {
		// TODO Auto-generated method stub

	}

}
