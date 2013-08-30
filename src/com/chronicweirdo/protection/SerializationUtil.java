package com.chronicweirdo.protection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class SerializationUtil {

	public static byte[] serialize(Object object) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(object);
		objOut.close();
		byte[] serializedObject = out.toByteArray();
		return serializedObject;
	}
	
	public static Object deserialize(byte[] bytes) throws Exception {
		ObjectInputStream objIn = new ObjectInputStream(new ByteArrayInputStream(bytes));
		return objIn.readObject();
	}
}
