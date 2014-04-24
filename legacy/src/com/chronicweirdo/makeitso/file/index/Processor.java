package com.chronicweirdo.makeitso.file.index;

import java.nio.file.Path;
import java.util.List;

/**
 * Processor takes an entry (a file) and generates index data. This index data can then be searched
 * through by a Searcher. Once the interesting data is obtained, an Accessor can be used to link
 * the data back to the entry (the file, the file + some position inside...)
 * @author cacovean
 *
 */
public interface Processor {

	List<IndexData> process(Path path);
}
