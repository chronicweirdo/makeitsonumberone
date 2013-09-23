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
	
	private Database db = new Database();

	private List loadDb(String path) throws Exception {
		File file = new File(path);
		return (List) SerializationUtil.deserialize(FileUtils.readFile(path));
	}
	
	private void saveDb(String path, List db) throws Exception {
		FileUtils.writeFile(path, SerializationUtil.serialize(db));
	}
	
	private void scanFiles(String path) {
		FilePathUtils.scan(new File(path), new FileScannerProcessor() {
			@Override
			public Object file(File file) {
				try {
					String id = file.getAbsolutePath();//FileIDUtils.bytesToHex(FileIDUtils.createMessageDigest(file.getAbsolutePath()));
					Node fileNode = new Node(StructureUtils.map(
							"name", file.getName(),
							"id", file.getAbsolutePath(),
							"lastModified", file.lastModified()
						));
					Test.this.db.addNode(fileNode);
					// look for parent
					if (file.getParentFile() != null) {
						Node parent = Test.this.db.findNode(Database.K_ID, file.getParentFile().getAbsolutePath());
						if (parent != null) {
							Link parentLink = new Link(parent, fileNode, 
									StructureUtils.map(Link.K_CLASS, Link.V_UNIDIRECTIONAL,
											Link.K_TYPE, Link.V_PARENT));
							Test.this.db.addLink(parentLink);
						}
					}
					return fileNode;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			public Object folder(File folder) {
				return file(folder);
			}
		});
	}
	
	public static void main(String[] args) throws Exception {
		String path = "/Users/cacovean/Dropbox/mydata";
		//String path = "\\Users\\cacovean\\Dropbox\\documents";
		//List lPath = FilePathUtils.path(path);
		//System.out.println(FilePathUtils.path("/", lPath));
		Test t = new Test();
		t.scanFiles(path);
		t.db.print();

		//List files = scanFiles(path);
		//List files = loadDb(path);
		
		/*for (Object o: files) {
			System.out.println(o.toString());
		}*/
		
		//saveDb(path, files);
	}

}
