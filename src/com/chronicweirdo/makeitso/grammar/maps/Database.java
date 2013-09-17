package com.chronicweirdo.makeitso.grammar.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.StructureUtils;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.protection.EncryptionUtils;
import com.chronicweirdo.protection.SerializationUtil;

public class Database {

	private static final byte[] SALT = "7jlErMXhVAhIDKWOgIxp".getBytes();
	
	private String path;
	private String password;
	private Map data = new HashMap();
	
	public Object set(List path, Object value) {
		return StructureUtils.set(data, path, value);
	}
	
	public Object get() {
		return get(null);
	}
	
	public Object get(List path) {
		return StructureUtils.get(data, path);
	}
	
	public Object delete(List path) {
		return StructureUtils.delete(data, path);
	}
	
	public void password(String password) {
		this.password = password;
	}
	
	public boolean save() {
		if (path == null) return false;
		try {
			byte[] bytes = SerializationUtil.serialize(data);
			if (password != null) {
				bytes = EncryptionUtils.encrypt(EncryptionUtils.key(password, SALT), bytes);
			}
			FileUtils.writeFile(path, bytes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean save(String path) {
		this.path = path;
		return save();
	}
		
	public Object load(String path) throws Exception {
		if (path == null) return false;
		try {
			byte[] bytes = FileUtils.readFile(path);
			if (password != null) {
				bytes = EncryptionUtils.decrypt(EncryptionUtils.key(password, SALT), bytes);
			}
			Object loaded = SerializationUtil.deserialize(bytes);
			return loaded;
		} catch (Throwable e) {
			//e.printStackTrace();
			throw new Exception("Failed to load.", e);
		}
	}
	
	public static void main(String[] args) {
		Database db = new Database();
		ConsoleUtils.print(db.data);

		List path = new ArrayList();
		path.add("var1");
		db.set(path, 5);
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
		
		path = new ArrayList();
		path.add("var2");
		path.add("var3");
		db.set(path, new ArrayList());
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
		
		path = new ArrayList();
		path.add("var2");
		path.add("var3");
		path.add("5");
		db.set(path, 17);
		System.out.println(db.get(path));
		ConsoleUtils.print(db.data);
	}

}
