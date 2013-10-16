package com.chronicweirdo.makeitso.path

import java.nio.file.Path

class TestProcessor implements FolderProcessor<String>, FileProcessor<String> {

	@Override
	public String processFile(Path root, Path relative) {
		return "processed file ($root) $relative";
	}

	@Override
	public String processFolder(Path root, Path relative) {
		return "processed folder ($root) $relative";
	}

}
