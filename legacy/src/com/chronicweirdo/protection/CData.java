package com.chronicweirdo.protection;

import java.io.Serializable;

public class CData implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776148L;

	private String password;

	public CData(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "<" + password + ">";
	}
	
	
}
