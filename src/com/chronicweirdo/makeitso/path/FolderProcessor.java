package com.chronicweirdo.makeitso.path;

import java.nio.file.Path;

/**
 * Implementing classes will take a folder and process it in some way, returning a result object.
 * 
 * @author cacovean
 *
 * @param <T> the result datatype
 */
public interface FolderProcessor<T> {

	T processFolder(Path root, Path relative);
	
}
