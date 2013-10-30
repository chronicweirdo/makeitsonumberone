package com.chronicweirdo.jon.grammar.test;

public class Test3 {

	public static final void main(String[] args) {
		System.out.println(args);
		Integer i = new Integer(1);
		Byte b = new Byte((byte) i.intValue());
		System.out.println(b);
		
		long l =  0xFFFFF;
		System.out.println(l);
		
		System.out.println(Long.parseLong("12345l"));
	}
}
