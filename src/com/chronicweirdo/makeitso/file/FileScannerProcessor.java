package com.chronicweirdo.makeitso.file;

import java.io.File;
import java.util.List;

public interface FileScannerProcessor {

	Object process(List<File> parents, File file);
}
