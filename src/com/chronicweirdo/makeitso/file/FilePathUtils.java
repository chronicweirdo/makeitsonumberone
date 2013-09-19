package com.chronicweirdo.makeitso.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilePathUtils {
	
	private static String FILE_SEPARATOR =
    		System.getProperties().getProperty("file.separator");
	private static String GO_BACK = "..";

	public static List scan(File file, FileScannerProcessor processor) {
		List result = new ArrayList();
		if (file.isDirectory()) {
			for (File f: file.listFiles()) {
				result.addAll(scan(f, processor));
			}
		} else {
			result.add(processor.process(file));
		}
		return result;
	}
	
	public static List path(String path) {
		String[] el = path.split("[/\\\\]");
		List result = new ArrayList();
		for (String s: el) {
			if (s.length() > 0) {
				result.add(s);
			}
		}
		return result;
	}
	
	public static String path(String prefix, List path) {
		StringBuilder builder = new StringBuilder();
		if (prefix != null) {
			builder.append(prefix);
		}
		String separator = "";
		for (Object p: path) {
			builder.append(separator).append(p.toString());
			separator = FILE_SEPARATOR;
		}
		return builder.toString();
	}
	
	public static List relativePath(List pathFrom, List pathTo) {
		int common = 0;
		while ((common < pathFrom.size()) && (common < pathTo.size())
				&& (pathFrom.get(common).equals(pathTo.get(common)))) {
			common++;
		}
		List relative = new ArrayList();
		int from = common;
		while (from < pathFrom.size()) {
			relative.add(GO_BACK);
			from++;
		}
		int to = common;
		while (to < pathTo.size()) {
			relative.add(pathTo.get(to));
			to++;
		}
		return relative;
	}
	
	public static void main(String[] args) throws Exception {
		// test on linux
		/*String path1 = "/Users/cacovean/Dropbox/documents";
		String path2 = "/Users/cacovean/Dropbox/documents/notes/travel";
		String path3 = "/Users/cacovean/Dropbox/documents/reading_notes/articles/neuroscience";
		System.out.println(relativePath(path(path1), path(path2)).toString());
		System.out.println(relativePath(path(path2), path(path1)).toString());
		System.out.println(relativePath(path(path3), path(path2)).toString());*/
		
		// test on windows
		String path1 = "c:\\Users\\cacovean\\Dropbox\\documents";
		String path2 = "c:\\Users\\cacovean\\Dropbox\\documents\\notes\\travel";
		String path3 = "c:\\Users\\cacovean\\Dropbox\\documents\\reading_notes\\articles\\neuroscience";
		List lPath1 = path(path1);
		System.out.println(lPath1.toString());
		System.out.println(relativePath(path(path1), path(path2)).toString());
		System.out.println(relativePath(path(path2), path(path1)).toString());
		System.out.println(relativePath(path(path3), path(path2)).toString());
		System.out.println(path(null, lPath1));
	}
}
