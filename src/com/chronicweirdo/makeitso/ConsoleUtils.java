package com.chronicweirdo.makeitso;

public class ConsoleUtils {

	
	public static void print(byte[] bytes) {
		print(bytes, false);
	}
	
	public static void print(byte[] bytes, boolean showSize) {
		if (showSize) {
			System.out.print(bytes.length + ": ");
		}
		System.out.print("[");
		String separator = "";
		for (byte b: bytes) {
			System.out.print(separator);
			System.out.print(b);
			separator = ", ";
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
