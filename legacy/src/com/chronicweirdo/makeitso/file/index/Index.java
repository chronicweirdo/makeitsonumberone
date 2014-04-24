package com.chronicweirdo.makeitso.file.index;

import java.nio.file.Path;
import java.util.List;

public interface Index {

	void process(Path path);
	void delete(Path path);
	List<IndexData> find(String query);
	void access(IndexData data);
}
