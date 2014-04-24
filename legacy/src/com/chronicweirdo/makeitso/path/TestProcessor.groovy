package com.chronicweirdo.makeitso.path

import java.nio.file.Path

class TestProcessor implements FolderProcessor<String>, FileProcessor<List<String>> {

	@Override
	public List<String> processFile(Path root, Path relative) {
		File file = root.resolve(relative).toFile();
		Date date = new Date(file.lastModified());
		return ["processed root $root", "processed file $relative", "last updated on $date"];
	}

	@Override
	public String processFolder(Path root, Path relative) {
		return "processed folder ($root) $relative";
	}

}
