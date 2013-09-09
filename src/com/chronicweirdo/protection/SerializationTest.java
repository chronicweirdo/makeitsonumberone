package com.chronicweirdo.protection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;

import com.chronicweirdo.makeitso.ConsoleUtils;
import com.chronicweirdo.makeitso.file.FileUtils;

public class SerializationTest {

	public static void testHashMapSerialization() throws IOException, ClassNotFoundException
    {
        HashMap map = new HashMap();
        map.put("abc", 1);
        map.put("def", 2);
        ConsoleUtils.print("original", map);

        // write 
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(map);
        objOut.close();
        byte[] serializedObject = out.toByteArray();
        
        // read
        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(serializedObject));
        HashMap actual = (HashMap) objIn.readObject();
        // now try to get a value
        ConsoleUtils.print("actual", actual);
    }
	
	public static void testHashMapSerializationEncryptionSave() throws Exception
    {
		// create map
        HashMap map = new HashMap();
        map.put("abc", 1);
        map.put("def", 2);
        ConsoleUtils.print("original", map);
        
        // serialize map
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        objOut.writeObject(map);
        objOut.close();
        byte[] serializedObject = out.toByteArray();
        
        // encrypt map
        String passphrase = "complicatedpasword";
        byte[] salt = "salty".getBytes();
        Key key = EncryptionTest.key2(passphrase, salt);
        byte[] encryptedSerializedObject = EncryptionTest.encrypt(key, serializedObject);
        
        // save to file
        String path = "objectData";
        FileUtils.writeFile(path, encryptedSerializedObject);
        
        // read from file
        byte[] readEncryptedSerializedObject = FileUtils.readFile(path);
        
        // decrypt
        key = EncryptionTest.key2(passphrase, salt);
        byte[] readSerializedObject = EncryptionTest.decrypt(key, readEncryptedSerializedObject);
        
        // deserialize
        ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(readSerializedObject));
        HashMap actual = (HashMap) objIn.readObject();
        // now try to get a value
        ConsoleUtils.print("actual", actual);
    }
	public static void testDeepHashMapSerializationEncryptionSave() throws Exception
	{
		// create map
		ArrayList list = new ArrayList();
		list.add("pretty");
		list.add("music");
		HashMap map2 = new HashMap();
		map2.put("tags", list);
		HashMap map = new HashMap();
		map.put("abc", 1);
		map.put("def", 2);
		map.put("deep", map2);
		ConsoleUtils.print("original", map);
		
		// serialize map
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(map);
		objOut.close();
		byte[] serializedObject = out.toByteArray();
		
		// encrypt map
		String passphrase = "complicatedpasword";
		byte[] salt = "salty".getBytes();
		Key key = EncryptionTest.key2(passphrase, salt);
		byte[] encryptedSerializedObject = EncryptionTest.encrypt(key, serializedObject);
		
		// save to file
		String path = "objectData";
		FileUtils.writeFile(path, encryptedSerializedObject);
		
		// read from file
		byte[] readEncryptedSerializedObject = FileUtils.readFile(path);
		
		// decrypt
		key = EncryptionTest.key2(passphrase, salt);
		byte[] readSerializedObject = EncryptionTest.decrypt(key, readEncryptedSerializedObject);
		
		// deserialize
		ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(readSerializedObject));
		HashMap actual = (HashMap) objIn.readObject();
		// now try to get a value
		ConsoleUtils.print("actual", actual);
	}
	
	public static void main(String[] args) throws Exception {
		testDeepHashMapSerializationEncryptionSave();
	}

}
