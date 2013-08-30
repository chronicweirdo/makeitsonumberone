package com.chronicweirdo.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		//listTest();
		mapTest();
	}

	public static void listTest() throws Exception {
		List<CKey> list = new ArrayList<CKey>();
		list.add(new CKey("facebook", "john.doe"));
		list.add(new CKey("twitter", "doedeer"));
		list.add(new CKey("8tracks", "doedeer"));
		System.out.println(list.toString());

		byte[] serialized = SerializationUtil.serialize(list);
		System.out.println(SerializationUtil.deserialize(serialized).toString());
	}
	
	public static void mapTest() throws Exception {
		Map<CKey, CData> map = new HashMap<CKey, CData>();
		map.put(new CKey("facebook", "john.doe"), new CData("YsasXywbut5T"));
		map.put(new CKey("twitter", "doedeer"), new CData("CB7BwuLzrgXw"));
		map.put(new CKey("8tracks", "doedeer"), new CData("Y2VzkZ8fnuFz"));
		System.out.println(map.toString());
		
		byte[] serialized = SerializationUtil.serialize(map);
		System.out.println(SerializationUtil.deserialize(serialized).toString());
	}

}
