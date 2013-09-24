package com.chronicweirdo.makeitso.file;

import java.util.ArrayList;
import java.util.List;

public class Path {

	private static String GO_BACK = "..";
	
	private boolean relative = false;
	private List<String> path;
	
	public Path(List<String> path, boolean relative) {
		this.path = path;
		this.relative = relative;
	}
	
	public Path(List<String> path) {
		this.path = path;
	}
	
	public Path(String path) {
		this.path = path(path);
		this.relative = checkRelative(path);
	}
	
	public List<String> get() {
		return path;
	}
	
	public boolean isRelative() {
		return relative;
	}
	
	public static Path relative(Path from, Path to) {
		if (from.isRelative() || to.isRelative()) return null;
		List rPath = relativePath(from.path, to.path);
		return new Path(rPath, true);
	}
	
	private static List relativePath(List pathFrom, List pathTo) {
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
	
	private static List<String> path(String path) {
		String[] el = path.split("[/\\\\:]");
		List<String> result = new ArrayList<String>();
		for (String s: el) {
			if (s.length() > 0) {
				result.add(s);
			}
		}
		return result;
	}
	
	private static boolean checkRelative(String path) {
		if (path.startsWith("/")) return false;
		if (path.matches("^.:.*")) return false;
		return true;
	}
	
	private static boolean isWindows() {
		String osName = System.getProperty("os.name");
		return "windows".equals(osName);
	}
	
	private static String getString(List<String> path, boolean relative) {
		if (isWindows()) {
			if (relative) {
				
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		if (path == null) {
			result = prime * result;
		} else {
			for (String p: path) {
				result = prime * result + ((p == null) ? 0 : p.hashCode());
			}
		}
		result = prime * result + (relative ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Path other = (Path) obj;
		if (relative != other.relative)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		}
		if (path.size() != other.path.size()) return false;
		for (int i = 0; i < path.size(); i++) {
			if (path.get(i) == null) {
				if (other.path.get(i) != null) {
					return false;
				}
			}
			if (!path.get(i).equals(other.path.get(i))) return false;
		}
		return true;
	}

	public String toString() {
		return "relative: " + relative + "; path: " + path.toString();
	}
	
	public static void main(String[] args) throws Exception {
		// test on linux
		//String path1 = "/Users/cacovean/Dropbox/documents";
		/*String path2 = "/Users/cacovean/Dropbox/documents/notes/travel";
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
		//System.out.println(path1.matches("^.:.*"));
		System.out.println(relative(new Path(path1), new Path(path2)).toString());
		System.out.println(relative(new Path(path2), new Path(path1)).toString());
		System.out.println(relative(new Path(path3), new Path(path2)).toString());
		//System.out.println(path(null, lPath1));
		isWindows();
	}
}
