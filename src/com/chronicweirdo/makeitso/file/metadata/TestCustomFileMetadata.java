package com.chronicweirdo.makeitso.file.metadata;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

import com.chronicweirdo.protection.SerializationUtil;

public class TestCustomFileMetadata {

	public static void tag(String sPath, String tag, Object value) throws Exception {
		UserDefinedFileAttributeView view = view(sPath);
		byte[] bytes = SerializationUtil.serialize(value);
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			buffer.put(i, bytes[i]);
		}
	    view.write(tag, buffer);
	}
	
	/*public static void tagString(String sPath, String tag, String value) throws Exception {
		UserDefinedFileAttributeView view = view(sPath);
		byte[] bytes = SerializationUtil.serialize(value);
		//ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		view.write(tag, Charset.defaultCharset().encode(value));
	}*/
	
	public static List<String> tags(String path) throws IOException {
		return view(path).list();
	}
	
	public static Object tag(String path, String tag) throws Exception {
		UserDefinedFileAttributeView view = view(path);
		ByteBuffer buf = ByteBuffer.allocate(view.size(tag));
		
	    view.read(tag, buf);
	    buf.flip();
	    byte[] bytes = new byte[buf.capacity()];
	    for (int i = 0; i < buf.capacity(); i++) {
	    	bytes[i] = buf.get(i);
	    }
	    Object value = SerializationUtil.deserialize(bytes);
	    return value;
	}
	
	public static void delete(String path, String tag) throws IOException {
		view(path).delete(tag);
	}

	private static UserDefinedFileAttributeView view(String path) {
		Path ppath = Paths.get(path);
		UserDefinedFileAttributeView view = Files.getFileAttributeView(ppath, UserDefinedFileAttributeView.class);
		return view;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "data.txt";
		
		/*
		List<String> list = new ArrayList<String>();
		list.add("cool");
		list.add("if");
		list.add("this");
		list.add("works");
		tag(path, "array", list);
		*/
		
		System.out.println(Files.size(Paths.get(path)));
		
		List<String> tags = tags(path);
		System.out.println(tags.toString());
		for (String tag: tags) {
			Object value = tag(path, tag);
			System.out.println(value.toString());
			delete(path, tag);
		}
	}

}
