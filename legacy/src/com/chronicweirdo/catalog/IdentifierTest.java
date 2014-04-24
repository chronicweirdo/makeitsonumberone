package com.chronicweirdo.catalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdentifierTest {

	public static byte[] createMessageDigest(String filename) throws Exception {
		InputStream in = new FileInputStream(filename);
		//MessageDigest md = MessageDigest.getInstance("MD5");
		MessageDigest md = MessageDigest.getInstance("SHA-256");

		byte[] buf = new byte[8192];
		int len;
		while ((len = in.read(buf)) != -1) {
		    md.update(buf, 0, len);
		}
		in.close();

		return md.digest();
	}
	
	public static String bytesToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder(2 * bytes.length);
		for (byte b : bytes) {
		    sb.append("0123456789ABCDEF".charAt((b & 0xF0) >> 4));
		    sb.append("0123456789ABCDEF".charAt((b & 0x0F)));
		}
		return sb.toString();
	}
	
	public static void findFile(String path, byte[] digest) throws Exception {
		File file = new File(path);
		//System.out.println("processing: " + file.getAbsolutePath());
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File child: file.listFiles()) {
					findFile(child.getAbsolutePath(), digest);
				}
			} else {
				byte[] currentDigest = createMessageDigest(file.getAbsolutePath());
				//System.out.println(bytesToHex(currentDigest));
				/*if (Arrays.equals(digest, currentDigest)) {
					System.out.println("found!: " + file.getAbsolutePath());
				}*/
				if (equalDigests(digest, currentDigest)) {
					System.out.println("found!: " + file.getAbsolutePath());
				}
			}
		}
	}
	
	public static boolean equalDigests(byte[] digest1, byte[] digest2) {
		if (digest1.length != digest2.length) return false;
		for (int i = 0; i < digest1.length; i++) {
			if (digest1[i] != digest2[i]) return false;
		}
		return true;
	}
	
	public static void addAll(Map<String, List<String>> map,
			Map<String, List<String>> mapFrom) {
		for (Map.Entry<String, List<String>> entry: mapFrom.entrySet()) {
			if (map.containsKey(entry.getKey())) {
				map.get(entry.getKey()).addAll(entry.getValue());
			} else {
				map.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public static Map<String, List<String>> merge(Map<String, List<String>> map1,
			Map<String, List<String>> map2) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		addAll(map, map1);
		addAll(map, map2);
		return map;
	}
	
	public static Map<String, List<String>> buildMap(String path) throws Exception {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		File file = new File(path);
		if (file.exists()) {
			if (file.isDirectory()) {
				for (File child: file.listFiles()) {
					Map<String, List<String>> returnMap = 
							buildMap(child.getAbsolutePath());
					addAll(map, returnMap);
					//System.out.println(map.size());
				}
			} else {
				byte[] digest = createMessageDigest(file.getAbsolutePath());
				String digestS = bytesToHex(digest);
				List<String> value = new ArrayList<String>();
				value.add(path);
				//System.out.println("putting " + digestS + " : " + value.toString());
				map.put(digestS, value);
			}
		}
		return map;
	}
	
	public static void main(String[] args) throws Exception {
		String path = "C:\\Users\\Silviu\\Downloads\\video-2013-08-18-19-10-18.mp4";
		byte[] digest = createMessageDigest(path);
		System.out.println(bytesToHex(digest));
		String folder = "C:\\Users\\Silviu\\Downloads";
		//findFile(folder, digest);
		Map<String, List<String>> map = buildMap(folder);
		System.out.println("listing duplicates");
		for (Map.Entry<String, List<String>> entry: map.entrySet()) {
			if (entry.getValue().size()>1) {
				System.out.println(entry.getKey());
				for (String s: entry.getValue()) {
					System.out.println(s);
				}
				System.out.println();
			}
		}
	}
}
