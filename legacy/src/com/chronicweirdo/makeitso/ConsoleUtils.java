package com.chronicweirdo.makeitso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ConsoleUtils {

	public static void print(Map map) {
		print(null, map);
	}
	
	public static void print(String name, Map map) {
		StringBuilder builder = new StringBuilder();
		PrettyPrintUtils.print(builder, name, map);
		System.out.println(builder.toString());
	}
	
	public static void print(String name, byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		PrettyPrintUtils.print(builder, name, bytes);
		System.out.println(builder.toString());
	}
	
	public static void print(byte[] bytes) {
		print(null, bytes);
	}
	
	public static void print(Object object) {
		print(null, object);
	}
	public static void print(String name, Object object) {
		StringBuilder builder = new StringBuilder();
		PrettyPrintUtils.print(builder, name, object);
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
