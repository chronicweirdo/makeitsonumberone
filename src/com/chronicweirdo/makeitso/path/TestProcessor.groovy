package com.chronicweirdo.makeitso.path

import java.nio.file.Path

class TestProcessor implements FolderProcessor<String>, FileProcessor<String> {

	@Override
	public String processFile(Path root, Path relative) {
		File file = root.resolve(relative).toFile();
		Date date = new Date(file.lastModified());
		return "processed file ($root) $relative ($date)";
	}

	@Override
	public String processFolder(Path root, Path relative) {
		return "processed folder ($root) $relative";
	}

}
