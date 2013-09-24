package com.chronicweirdo.makeitso.graph;

import java.io.File;
import java.util.List;
import java.util.UUID;

import com.chronicweirdo.makeitso.StructureUtils;
import com.chronicweirdo.makeitso.file.FilePathUtils;
import com.chronicweirdo.makeitso.file.FileScannerProcessor;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.makeitso.file.Path;
import com.chronicweirdo.protection.SerializationUtil;

public class Test {
	
	private static final String DB_NAME = "exo.db";
	
	private Database db;
	
	public void setDatabase(Database database) {
		this.db = database;
	}

	private static Database loadDb(String path) throws Exception {
		File file = new File(path);
		return (Database) SerializationUtil.deserialize(FileUtils.readFile(path));
	}
	
	private static void saveDb(String path, Database db) throws Exception {
		FileUtils.writeFile(path, SerializationUtil.serialize(db));
	}
	
	
	/*
	 * IMPORTANT TO DECIDE HOW TO IDENTIFY DATA
	 * NODES ARE IDENTIFIED BY IDS
	 * LINKS ARE IDENTIFIED BY NODES THEY LINK AND TYPE AND DIRECTION/CLASS (DIRECTION ENCODED IN NODES
	 * THEY LINK)
	 * KEEY ATTRIBUTES FOR BOTH
	 */
	
	private void update(String path) {
		final Path absoluteDatabasePath = new Path(db.getPath());
		// rescan folder and update existing data
		List updatedIDs = FilePathUtils.scan(new File(path), new FileScannerProcessor() {
			@Override
			public Object file(File file) {
				try {
					Path absoluteFilePath = new Path(file.getAbsolutePath());//FileIDUtils.bytesToHex(FileIDUtils.createMessageDigest(file.getAbsolutePath()));
					Path relativeFilePath = Path.relative(absoluteDatabasePath, absoluteFilePath);
					Path id = relativeFilePath;
					Node fileNode = new Node(StructureUtils.map(
							"name", file.getName(),
							"id", id,
							"lastModified", file.lastModified()
						));
					Object updatedId = Test.this.db.updateNode(fileNode);
					// look for parent
					if (file.getParentFile() != null) {
						Path absoluteParentPath = new Path(file.getParentFile().getAbsolutePath());
						Path relativeParentPath = Path.relative(absoluteDatabasePath, absoluteParentPath);
						Node parent = Test.this.db.findNode(Database.K_ID, relativeParentPath);
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
		// clear data that was not found on rescan
	}
	
	public void open(String path) throws Exception {
		// check if folder contains db.exo file
		Path root = new Path(path);
		Path dbexo = new Path(root, "db.exo");
		File dbexoFile = new File(dbexo.getOSPath());
		if (dbexoFile.exists()) {
			// load db
			this.db = loadDb(dbexo.getOSPath());
			// update db
			// save db
			saveDb(dbexo.getOSPath(), this.db);
		} else {
			// create db
			// update db
			// save db
			saveDb(dbexo.getOSPath(), this.db);
		}
		System.out.println(dbexoFile.exists());
	}
	
	public static void scanTest(String path) {
		Test t = new Test();
		t.setDatabase(new Database(UUID.randomUUID().toString(), path));
		t.scanFiles(path);
		t.db.print();
		//saveDb(path + "/db.exo", t.db);
	}
	public static void openTest(String path) {
		Test t = new Test();
		t.open(path);
	}
	
	public static void main(String[] args) throws Exception {
		String path = "/Users/cacovean/Dropbox/mydata/travel";
		//scanTest(path);
		openTest(path);
	}

}
