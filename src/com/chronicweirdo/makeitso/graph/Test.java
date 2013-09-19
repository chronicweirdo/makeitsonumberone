package com.chronicweirdo.makeitso.graph;

import java.io.File;
import java.util.List;

import com.chronicweirdo.makeitso.StructureUtils;
import com.chronicweirdo.makeitso.file.FilePathUtils;
import com.chronicweirdo.makeitso.file.FileScannerProcessor;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.protection.SerializationUtil;

public class Test {
	
	private static final String DB_NAME = "exo.db";

	private static List loadDb(String path) throws Exception {
		File file = new File(path);
		return (List) SerializationUtil.deserialize(FileUtils.readFile(path));
	}
	
	private static void saveDb(String path, List db) throws Exception {
		FileUtils.writeFile(path, SerializationUtil.serialize(db));
	}
	
	private static List scanFiles(String path) {
		List files = FilePathUtils.scan(new File(path), new FileScannerProcessor() {

			@Override
			public Object process(File file) {
				try {
					String id = file.getAbsolutePath();//FileIDUtils.bytesToHex(FileIDUtils.createMessageDigest(file.getAbsolutePath()));
					Node fileNode = new Node(id, StructureUtils.map(
							"name", file.getName(),
							"path", file.getAbsolutePath(),
							"lastModified", file.lastModified()
						));
					return fileNode;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		});
		return files;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "/Users/cacovean/Dropbox/documents";
		//String path = "\\Users\\cacovean\\Dropbox\\documents";
		List lPath = FilePathUtils.path(path);
		System.out.println(FilePathUtils.path("/", lPath));

		//List files = scanFiles(path);
		//List files = loadDb(path);
		
		/*for (Object o: files) {
			System.out.println(o.toString());
		}*/
		
		//saveDb(path, files);
	}

}
