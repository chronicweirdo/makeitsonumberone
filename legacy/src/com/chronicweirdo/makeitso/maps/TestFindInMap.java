package com.chronicweirdo.makeitso.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class TestFindInMap {

	private static final String VOCABULARY =
			"abcdefghijklmnopqrstuvwxyz0123456789_.";
	private static final Integer MAX_STRING_SIZE = 20;
	
	private Random random = new Random(System.currentTimeMillis());
	
	
	
	private Map<String, String> hashMap = new HashMap<String, String>();
	private Map<String, String> treeMap = new TreeMap<String, String>();
	
	private long randomSamples = 50;
	private List<String> randomKeys = new ArrayList<String>();
	
	private long size = 1000000000;
	
	private String randomString() {
		Integer size = random.nextInt(MAX_STRING_SIZE);
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < size; index++) {
			Integer chosen = random.nextInt(VOCABULARY.length());
			String character = VOCABULARY.substring(chosen,chosen+1);
			builder.append(character);
		}
		return builder.toString();
	}
	
	private void fillMaps() {
		for (long i = 0; i < size; i++) {
			String key = randomString();
			String value = randomString();
			if (i % (size / randomSamples) == 0) {
				randomKeys.add(key);
			}
			hashMap.put(key, value);
			treeMap.put(key, value);
		}
	}
	
	private void testMaps() {
		System.out.println("searching for " + randomKeys.size() + " keys");
		long hashMapTime = 0;
		long treeMapTime = 0;
		long startTime = 0;
		long endTime = 0;
		for (String key: randomKeys) {
			startTime = System.currentTimeMillis();
			hashMap.containsKey(key);
			endTime = System.currentTimeMillis();
			hashMapTime += (endTime - startTime);
			
			startTime = System.currentTimeMillis();
			treeMap.containsKey(key);
			endTime = System.currentTimeMillis();
			treeMapTime += (endTime - startTime);
		}
		System.out.println("tree map time: " + treeMapTime);
		System.out.println("hash map time: " + hashMapTime);
	}
	
	public static void main(String[] args) {
		System.out.println(Long.MAX_VALUE);
		TestFindInMap t = new TestFindInMap();
		t.fillMaps();
		t.testMaps();
	}

}
