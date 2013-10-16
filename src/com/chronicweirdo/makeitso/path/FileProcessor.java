package com.chronicweirdo.makeitso.path;

import java.nio.file.Path;

/**
 * The implementing clases will process a file somehow and return a result object.
 * 
 * @author cacovean
 *
 * @param <T>
 */
public interface FileProcessor<T> {

	T processFile(Path root, Path relative);
}
