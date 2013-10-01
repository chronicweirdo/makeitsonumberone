package com.chronicweirdo.makeitso.grammar.wiki.text;

import java.util.ArrayList;
import java.util.List;

public class Block implements Section {

	private Tag name;
	private List<Section> sections;
	
	public Block(Tag name, List<Section> sections) {
		this.name = name;
		this.sections = new ArrayList<Section>(sections);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<").append(name.toString()).append(">");
		for (Section section: sections) {
			builder.append(section.toString());
		}
		builder.append("</>");
		return builder.toString();
	}
}
