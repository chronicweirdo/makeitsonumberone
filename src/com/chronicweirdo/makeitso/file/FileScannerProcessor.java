package com.chronicweirdo.makeitso.file;

import java.io.File;
import java.util.List;

public interface FileScannerProcessor {

	Object folder(File folder);
	
	Object file(File file);
}
