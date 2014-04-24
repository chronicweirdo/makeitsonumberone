package com.chronicweirdo.makeitso.file;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class FileIDUtils {

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
}
