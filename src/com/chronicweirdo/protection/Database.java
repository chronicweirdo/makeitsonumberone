package com.chronicweirdo.protection;

import java.io.File;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.FileUtils;

public class Database {

	private static final String SALT = "thisisthesaltusedforencyption";
	
	private String path;
	private String password;
	private Map db;
	
	private static final Map loadDB(String path, String password) throws Exception {
		File file = new File(path);
		if (file.exists()) {
			byte[] data = FileUtils.readFile(path);
			Key key = EncryptionUtils.key(password, SALT);
			byte[] decrypted = EncryptionUtils.decrypt(key, data);
			Map result = (Map) SerializationUtil.deserialize(decrypted);
			return result;
		} else {
			return new HashMap();
		}
	}
	
	private static final void saveDB(String path, String password, Map<CKey, CData> db) throws Exception {
		byte[] serialized = SerializationUtil.serialize(db);
		Key key = EncryptionUtils.key(password, SALT);
		byte[] encrypted = EncryptionUtils.encrypt(key, serialized);
		FileUtils.writeFile(path, encrypted);
	}
	
	public Database(String path, String password) throws Exception {
		this.path = path;
		this.password = password;
		this.db = loadDB(path, password);
	}
	
	public void save() throws Exception {
		saveDB(path, password, db);
	}
	
	private Object get(Map map, String key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}
	
	private Object get(Object source, String key) {
		if (source == null) return null;
		if (source instanceof Map) {
			return get((Map) source, key);
		}
		return null;
	}
	
	public Object get(String ... key) {
		Object db = this.db;
		for (String k: key) {
			db = get(db, k);
		}
		return db;
	}
	
	public void set(String key, Object object) {
		db.put(key, object);
	}
	
	public static void main(String[] args) throws Exception {
		/*Database db = new Database("credentials2", "password");
		db.set("test", "test value");
		db.save();
		
		Database db2 = new Database("credentials2", "password");
		System.out.println(db2.db.toString());
		System.out.println(db2.get("test"));
		System.out.println(db2.get("test", "a"));*/
		
	}
}
