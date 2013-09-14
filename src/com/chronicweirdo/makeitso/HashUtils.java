package com.chronicweirdo.makeitso;

import java.lang.reflect.Array;

public class HashUtils {

	public static final int SEED = 23;
	private static final int PRIME_NUMBER = 37;

	private static int firstTerm(int aSeed) {
		return PRIME_NUMBER * aSeed;
	}

	private static boolean isArray(Object aObject) {
		return aObject.getClass().isArray();
	}
	
	public static int hash(int aSeed , int aInt) {
	    return firstTerm(aSeed) + aInt;
	}

	public static int hash(Object aObject) {
		return hash(SEED, aObject);
	}
	
	public static int hash(int aSeed, Object aObject) {
		int result = aSeed;
		if (aObject == null) {
			result = hash(result, 0);
		} else if (!isArray(aObject)) {
			result = hash(result, aObject.hashCode());
		} else {
			int length = Array.getLength(aObject);
			for (int idx = 0; idx < length; ++idx) {
				Object item = Array.get(aObject, idx);
				// recursive call!
				result = hash(result, item);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(hash("string"));
		System.out.println(hash(777));
		System.out.println(hash(args));
		System.out.println(hash(new Boolean(true)));
		System.out.println(hash(new Boolean(false)));
		System.out.println(hash(2147483647000l));
	}
}
