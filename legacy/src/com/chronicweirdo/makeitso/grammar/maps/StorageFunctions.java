package com.chronicweirdo.makeitso.grammar.maps;

import java.io.Console;
import java.util.List;
import java.util.Map;

import com.chronicweirdo.makeitso.Struct;
import com.chronicweirdo.makeitso.file.FileUtils;
import com.chronicweirdo.protection.EncryptionUtils;
import com.chronicweirdo.protection.SerializationUtil;

public class StorageFunctions implements Functions {
	
	private static final byte[] SALT = "7jlErMXhVAhIDKWOgIxp".getBytes();
	
	private static final String F_SAVE = "save";
	private static final String F_LOAD = "load";
	private static final String F_PASS = "pass";
	
	private static final String E_PASS = "Failed to read password!";
	private static final String E_PASS_MATCH = "Passwords don't match!";
	private static final String E_PASS_CONS = "No console available!";
	private static final String M_PASS1 = "password:";
	private static final String M_PASS2 = "confirm:";

	private String password = null;
	
	private static Object save(Object object, String path, String password) throws Exception {
		if (path == null) return false;
		try {
			byte[] bytes = SerializationUtil.serialize(object);
			if (password != null) {
				bytes = EncryptionUtils.encrypt(EncryptionUtils.key(password, SALT), bytes);
			}
			FileUtils.writeFile(path, bytes);
			return object;
		} catch (Exception e) {
			throw new Exception("Failed to save.", e);
		}
	}
		
	private static Object load(String path, String password) throws Exception {
		if (path == null) return false;
		try {
			byte[] bytes = FileUtils.readFile(path);
			if (password != null) {
				bytes = EncryptionUtils.decrypt(EncryptionUtils.key(password, SALT), bytes);
			}
			Object loaded = SerializationUtil.deserialize(bytes);
			return loaded;
		} catch (Throwable e) {
			throw new Exception("Failed to load.", e);
		}
	}
	
	private static String readPassword() throws Exception {
		try {
			Console cons = System.console();
			if (cons != null) {
				char[] cpassword2 = cons.readPassword("%s", M_PASS1);
				char[] cpassword1 = cons.readPassword("%s", M_PASS2);
				String password1 = String.copyValueOf(cpassword1);
				String password2 = String.copyValueOf(cpassword2);
				if (password1 != null && password2 != null
						&& password1.equals(password2)) {
					return password1;
				} else {
					throw new Exception(E_PASS_MATCH);
				}
			} else {
				throw new Exception(E_PASS_CONS);
			}
		} catch (Exception e) {
			throw new Exception(E_PASS, e);
		}
	}

	@Override
	public Object function(Map map) throws Exception {
		String function = (String) map.get(P_FUNCTION);
		if (function.equals(F_SAVE)) {
			return save(map.get(P_VALUE), map.get(P_PATH).toString(), password);
		} else if (function.equals(F_LOAD)) {
			return load(map.get(P_PATH).toString(), password);
		} else if (function.equals(F_PASS)) {
			password = readPassword();
			return null;
		}
		throw new Exception(E_FUNCTION);
	}

	@Override
	public Object function(String name, List parameters) throws Exception {
		if (name.equals(F_SAVE) && parameters.size() == 2) {
			return function(Struct.map(P_FUNCTION, name, P_VALUE, parameters.get(0),
					P_PATH, parameters.get(1)));
		} else if (name.equals(F_LOAD) && parameters.size() == 1) {
			return function(Struct.map(P_FUNCTION, name, P_PATH, parameters.get(0)));
		} else if (name.equals(F_PASS) && parameters.size() == 0) {
			return function(Struct.map(P_FUNCTION, name));
		}
		throw new Exception(E_FUNCTION);
	}

}
