package com.chronicweirdo.makeitso.file.index

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString;

import com.chronicweirdo.makeitso.index.tag.Position
import com.chronicweirdo.makeitso.index.tag.Tag

@EqualsAndHashCode
@ToString
class TagIndexData implements IndexData {

	Tag tag;
	Position position;
	
	TagIndexData(Tag tag, Position position) {
		this.tag = tag;
		this.position = position;
	}
	
	@Override
	public Map<String, Object> getSearchTerms() {
		return ["tag":tag.name, "value":tag.value/*, "path": position.path, "line": position.line*/];
	}
}
