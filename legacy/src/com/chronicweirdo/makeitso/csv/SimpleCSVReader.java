package com.chronicweirdo.makeitso.csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleCSVReader {

	private String path;
	private List<String> header = new ArrayList<String>();
	private List<Map<String, String>> records = new ArrayList<Map<String, String>>();
	
	public SimpleCSVReader(String path) {
		this.path = path;
		this.readFile();
	}
	
	private String[] split(String line) {
		String[] split = line.split(",", -1);
		System.out.println("line split into " + split.length);
		return split;
	}
	private void processHeader(String line) {
		this.header = Arrays.asList(this.split(line));
	}
	private void processLine(String line) {
		String[] splitLine = this.split(line);
		Map<String, String> record = new HashMap<String, String>();
		for (int i = 0; i < this.header.size(); i++) {
			record.put(this.header.get(i), splitLine[i]);
		}
		this.records.add(record);
	}
	private void readFile() {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-16"));
			String line = bufferedReader.readLine();
			processHeader(line);
			while ((line = bufferedReader.readLine()) != null) {
				//System.out.println(line);
				processLine(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)bufferedReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void print() {
		for (Map<String, String> record: records) {
			for (Map.Entry<String, String> entry: record.entrySet()) {
				if (entry.getValue() != null && !entry.getValue().isEmpty()) {
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String path = "C:\\Users\\Silviu\\Downloads\\google.csv";
		SimpleCSVReader reader = new SimpleCSVReader(path);
		reader.print();
	}

}
