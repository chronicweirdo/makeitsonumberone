package com.chronicweirdo.makeitso.file.index

/**
 * We need a general index "director" that can handle all indexing functionality for a group of
 * files.
 * 
 * 1. The index is always based on a "root" location (folder).
 * 2. Have functionality to convert existing index to a different root.
 * 3. Merging of indexes, based on 2.
 * 4. Support pluggable processors - each processor creates data for a different index.
 * 5. Support pluggable accessors, that allow opening files based based on index data - one
 * accessor for each index.
 * 6. An API + CLI (command line interface).
 * 
 * @author cacovean
 *
 */
class Principal {

	Map<String, Map<Object, List>> indexes;
}
