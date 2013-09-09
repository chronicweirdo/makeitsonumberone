package com.chronicweirdo.makeitso.file.metadata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.List;

import com.chronicweirdo.protection.SerializationUtil;

public class TestCustomFileMetadata {

	private static void tag(String sPath, String tag, Object value) throws Exception {
		UserDefinedFileAttributeView view = view(sPath);
		byte[] bytes = SerializationUtil.serialize(value);
		ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		for (int i = 0; i < bytes.length; i++) {
			buffer.put(i, bytes[i]);
		}
		//buffer.put(bytes);
	    view.write(tag, buffer);
	}
	private static void tagString(String sPath, String tag, String value) throws Exception {
		UserDefinedFileAttributeView view = view(sPath);
		byte[] bytes = SerializationUtil.serialize(value);
		//ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
		view.write(tag, Charset.defaultCharset().encode(value));
	}
	
	private static List<String> tags(String path) throws IOException {
		return view(path).list();
	}
	
	private static Object tag(String path, String tag) throws Exception {
		UserDefinedFileAttributeView view = view(path);
		ByteBuffer buf = ByteBuffer.allocate(view.size(tag));
		
	    view.read(tag, buf);
	    buf.flip();
	    byte[] bytes = new byte[buf.capacity()];
	    //System.out.println(buf.capacity());
	    for (int i = 0; i < buf.capacity(); i++) {
	    	//buf.position(i);
	    	bytes[i] = buf.get(i);
	    	//System.out.println(buf.get());
	    }
	    //ConsoleUtils.print(bytes);
	    Object value = SerializationUtil.deserialize(bytes);
	    return value;
	    //return null;
	}

	private static UserDefinedFileAttributeView view(String sPath) {
		Path path = Paths.get(sPath);
		UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
		return view;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "data.txt";
		
		//File file = new File(sPath);
		//System.out.println(file.exists());
		//Files.setAttribute(path, "tags", "text_file");
		//Map<String, Object> attributes = Files.readAttributes(path, "*");
		//System.out.println(attributes.toString());
		
		
	    //attributes = Files.readAttributes(path, "*");
		//System.out.println(attributes.toString());
		//writeTags(sPath, "mood", "happy");
		//tag(path, "mood", "happy");
		//tag(path, "user.tags", "text_File");
		
		/*
		List<String> list = new ArrayList<String>();
		list.add("cool");
		list.add("if");
		list.add("this");
		list.add("works");
		tag(path, "array", list);
		*/
		
		List<String> tags = tags(path);
		System.out.println(tags.toString());
		for (String tag: tags) {
			Object value = tag(path, tag);
			System.out.println(value.toString());
		}
	}

}
