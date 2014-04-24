package com.chronicweirdo.makeitso.index.tag

import java.nio.file.Path
import com.chronicweirdo.makeitso.path.FileProcessor

/**
 * This processor just logs which files have been processed by the file processor, it creates a
 * log of relative paths.
 * @author cacovean
 *
 */
class FileLogProcessor implements FileProcessor<Path> {

	@Override
	public Path processFile(Path root, Path relative) {
		return relative;
	}

}
