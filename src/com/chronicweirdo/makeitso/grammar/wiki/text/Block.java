package com.chronicweirdo.makeitso.grammar.wiki.text;

import java.util.ArrayList;
import java.util.List;

public class Block implements Section {

	private List<Section> open;
	private List<Section> name;
	private List<Section> contents;
	
	public Block(List<Section> open, List<Section> contents) throws Exception {
		this.open = new ArrayList<Section>();
		this.name = new ArrayList<Section>();
		for (Section section: open) {
			if (section instanceof Tag
					|| section instanceof Text
					|| section instanceof Space) {
				this.open.add(section);
				if (!(section instanceof Space)) {
					this.name.add(section);
				}
			} else {
				throw new Exception("Unaccepted section");
			}
		}
		this.contents = new ArrayList<Section>(contents);
	}
	
	public List<Section> getOpen() {
		return this.open;
	}
	
	public List<Section> getName() {
		return this.name;
	}
	
	public List<Section> getContents() {
		return this.contents;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("<");
		for (Section section: open) {
			builder.append(section.toString());
		}
		builder.append(">");
		for (Section section: contents) {
			builder.append(section.toString());
		}
		builder.append("</>");
		return builder.toString();
	}
}
