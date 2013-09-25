package com.chronicweirdo.makeitso.graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.chronicweirdo.makeitso.file.FilePathUtils;
import com.chronicweirdo.makeitso.file.FileScannerProcessor;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.makeitso.file.Path;
import com.chronicweirdo.protection.SerializationUtil;

public class Test {
	
	private static final String DB_NAME = "exo.db";
	
	//private Database db;
	private Graph graph;
	
	public Test() {
		this.graph = new Graph();
	}
	
	/*public void setDatabase(Database database) {
		this.db = database;
	}*/

	private static Object loadObject(String path) throws Exception {
		File file = new File(path);
		if (file.exists()) {
			return SerializationUtil.deserialize(FileUtils.readFile(path));
		} else {
			return null;
		}
	}
	
	private static void saveObject(String path, Object o) throws Exception {
		FileUtils.writeFile(path, SerializationUtil.serialize(o));
	}

	
	
	/*
	 * IMPORTANT TO DECIDE HOW TO IDENTIFY DATA
	 * NODES ARE IDENTIFIED BY IDS
	 * LINKS ARE IDENTIFIED BY NODES THEY LINK AND TYPE AND DIRECTION/CLASS (DIRECTION ENCODED IN NODES
	 * THEY LINK)
	 * KEEY ATTRIBUTES FOR BOTH
	 */
	
	private static class GraphFileScannerProcessor implements FileScannerProcessor {
		private Path root;
		private Graph graph;
		
		public GraphFileScannerProcessor(String root, Graph graph) {
			this.root = new Path(root);
			this.graph = graph;
		}
		
		@Override
		public Object file(File file) {
			try {
				// HANDLING NODE
				// obtain relevant data about this file
				Path absoluteFilePath = new Path(file.getAbsolutePath());//FileIDUtils.bytesToHex(FileIDUtils.createMessageDigest(file.getAbsolutePath()));
				Path relativeFilePath = Path.relative(root, absoluteFilePath);
				String name = file.getName();
				Long lastModified = file.lastModified();
				
				// put data into a filter
				AndCondition and = new AndCondition()
					.add(new TypeCondition(Node.class))
					.add(new AttributeEqualsCondition("path", relativeFilePath));
				
				// get existing node, if any
				Node node = (Node) graph.get(and);
				
				// create new node and add to graph, if none
				if (node == null) {
					node = new Node();
					node.set("path", relativeFilePath);
					graph.add(node);
				}
				
				// update node data
				node.set("name", name);
				node.set("lastModified", lastModified);
			
				// HANDLING LINKS
				if (file.getParentFile() != null) {
					// get parent node
					Path absoluteParentPath = new Path(file.getParentFile().getAbsolutePath());
					Path relativeParentPath = Path.relative(root, absoluteParentPath);
					Node parent = (Node) graph.get(new AndCondition()
							.add(new TypeCondition(Node.class))
							.add(new AttributeEqualsCondition("path", relativeParentPath))
						);
					if (parent != null) {
						// find "parent" link
						Condition linkCondition = new AndCondition()
							.add(new LinkEndCondition(new AttributeEqualsCondition("path", relativeParentPath)))
							.add(new LinkEndCondition(new AttributeEqualsCondition("path", relativeFilePath)))
							.add(new AttributeEqualsCondition("type", "parent"));
						Link link = (Link) graph.get(linkCondition);
						// if it does not exist, create it
						if (link == null) {
							link = new Link(parent, node);
							link.set("type", "parent");
							graph.add(link);
						}
					}
				}
				return node.get("path");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		public Object folder(File folder) {
			return file(folder);
		}
	}
	
	private void update(String path) {
		// rescan folder and update existing data
		List updatedIDs = FilePathUtils.scan(new File(path), new GraphFileScannerProcessor(path, graph));
		// clear data that was not found on rescan
		Condition deleteCondition = new AndCondition()
				.add(new TypeCondition(Node.class))
				.add(new NotCondition(new AttributeInCondition("path", updatedIDs)));
		List<GREL> nodes = graph.filter(deleteCondition);
		List<GREL> deleted = new ArrayList<GREL>();
		for (GREL grel: nodes) {
			try {
				deleted.addAll(graph.delete(grel));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("deleted " + deleted.size() + " elements");
	}
	
	public static void updateTest(String path) throws Exception {
		String gpath = path + "/g.exo";
		Object o = loadObject(gpath);
		Test t = new Test();
		if (o != null) {
			t.graph = (Graph) o;
		}
		t.update(path);
		t.graph.print();
		saveObject(gpath, t.graph);
	}
	
	public static void main(String[] args) throws Exception {
		String path = "/Users/cacovean/Dropbox/mydata/travel";
		//scanTest(path);
		updateTest(path);
	}

}
