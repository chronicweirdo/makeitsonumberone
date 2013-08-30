package com.chronicweirdo.makeitso;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileUtils {

	public static String readTextFile(String path) {
		try {
			StringBuilder builder = new StringBuilder();
			FileInputStream fstream = new FileInputStream(path);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				builder.append(strLine).append("\n");
			}
			in.close();
			return builder.toString();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}

	public static void writeFile(String path, byte[] data) throws IOException {
		FileOutputStream stream = new FileOutputStream(path);
		stream.write(data);
		stream.close();
	}

	public static byte[] readFile(String path) throws Exception {
		File file = new File(path);
		/*
		 * if ( file.length() > MAX_FILE_SIZE ) { throw new
		 * FileTooBigException(file); }
		 */
		ByteArrayOutputStream byteArrayOutputStream = null;
		InputStream inputStream = null;
		try {
			byte[] buffer = new byte[4096];
			byteArrayOutputStream = new ByteArrayOutputStream();
			inputStream = new FileInputStream(file);
			int read = 0;
			while ((read = inputStream.read(buffer)) != -1) {
				byteArrayOutputStream.write(buffer, 0, read);
			}
		} finally {
			try {
				if (byteArrayOutputStream != null) {
					byteArrayOutputStream.close();
				}
			} catch (IOException e) {
			}

			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
			}
		}
		return byteArrayOutputStream.toByteArray();
	}

	public static void writeFile(String path, String text) {
		writeFile(path, text, false);
	}

	public static void appendFile(String path, String text) {
		writeFile(path, text, true);
	}

	public static void writeFile(String path, String text, boolean append) {
		try {
			FileWriter outFile = new FileWriter(path, append);
			PrintWriter out = new PrintWriter(outFile);
			out.print(text);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String path = "data1.txt";
		String text = "this is\na multi\nline text";
		System.out.println(text);
		System.out.println("--------------");
		writeFile(path, text);
		System.out.println(readTextFile(path));
	}

}
