package com.chronicweirdo.makeitso.graph;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.chronicweirdo.makeitso.StructureUtils;

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
	
	public void set(String key, Object value) {
		StructureUtils.set(attributes, StructureUtils.path(key), value);
	}
	
	public Object get(String key) {
		return StructureUtils.get(attributes, StructureUtils.path(key));
	}

	@Override
	public String toString() {
		return "[attributes=" + attributes.toString() + "]";
	}
	
}
