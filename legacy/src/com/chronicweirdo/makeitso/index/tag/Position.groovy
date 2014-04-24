package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path

class Position {

	Path path;
	Integer line;
	
	@Override
	public String toString() {
		return "($path,$line)";
	}
}
