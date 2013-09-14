package com.chronicweirdo.protection;

import java.io.Serializable;

import com.chronicweirdo.makeitso.HashUtils;

public class CKey implements Serializable {
	
	private static final long serialVersionUID = 7526472295622776147L;
	
	private String site;
	private String login;

	public CKey(String site, String login) {
		this.site = site;
		this.login = login;
	}
	
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "<" + site + ":" + login + ">";
	}

	@Override
	public boolean equals(Object thatO) {
		if (this == thatO) return true;
	    if (!(thatO instanceof CKey)) return false;
	    CKey that = (CKey) thatO;
	    
	    return
	    		(this.site == null ? that.site == null : this.site.equals(that.site))
	    		&& (this.login == null ? that.login == null : this.login.equals(that.login));
	}

	@Override
	public int hashCode() {
		int hash = HashUtils.hash(login);
		hash = HashUtils.hash(hash, site);
		return hash;
	}
	
	
}