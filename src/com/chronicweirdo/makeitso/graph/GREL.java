package com.chronicweirdo.makeitso.graph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.chronicweirdo.makeitso.Struct;

/**
 * A GRaph ELement.
 * @author cacovean
 *
 */
public class GREL implements Serializable {
	
	public static final String K_TYPE = "type";
	public static final String V_FILE = "file";
	public static final String V_FOLDER = "folder";

	private static final long serialVersionUID = 1666438291981055759L;
	
	protected Map attributes;
	
	public GREL() {
		this.attributes = new HashMap();
	}
	
	public GREL(Map attributes) {
		this();
		this.attributes.putAll(attributes);
	}
	
	public void set(Object key, Object value) {
		Struct.set(attributes, Struct.list(key), value);
	}
	
	public Object get(Object key) {
		return Struct.get(attributes, Struct.list(key));
	}
	
	public Set keys() {
		return attributes.keySet();
	}

	@Override
	public String toString() {
		return "[attributes=" + attributes.toString() + "]";
	}
	
}
