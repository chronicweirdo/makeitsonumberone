package com.chronicweirdo.makeitso.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.makeitso.Struct;

public class FilePathUtils {
	
	private static String FILE_SEPARATOR =
    		System.getProperties().getProperty("file.separator");
	

	/*public static List scan(File file, FileScannerProcessor processor) {
		return scan(
				new ArrayList(),
				file,
				processor
			);
	}*/
	public static List scan(
			//List<File> parents,
			File file,
			FileScannerProcessor processor
		) {
		List result = new ArrayList();
		if (file.isDirectory()) {
			result.add(processor.folder(file));
			for (File f: file.listFiles()) {
				result.addAll(scan(
						//StructureUtils.duplicate(parents, file),
						f,
						processor
					));
			}
		} else {
			result.add(processor.file(
					//parents,
					file
				));
		}
		return result;
	}
	
	
	public static void main(String[] args) throws Exception {
	}
}
