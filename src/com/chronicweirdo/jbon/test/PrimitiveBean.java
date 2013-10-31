package com.chronicweirdo.jbon.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrimitiveBean {

	private Boolean vBoolean;
	private Byte vByte;
	private Short vShort;
	private int vInteger;
	private Long vLong;
	private Double vDouble;
	private Float vFloat;
	private String vString;
	private Character vCharacter;
	private Map vMap;
	private List vList;
	private Set vSet;
	
	public Map getvMap() {
		return vMap;
	}
	public void setvMap(Map vMap) {
		this.vMap = vMap;
	}
	public List getvList() {
		return vList;
	}
	public void setvList(List vList) {
		this.vList = vList;
	}
	public Set getvSet() {
		return vSet;
	}
	public void setvSet(Set vSet) {
		this.vSet = vSet;
	}
	public Boolean getvBoolean() {
		return vBoolean;
	}
	public void setvBoolean(Boolean vBoolean) {
		this.vBoolean = vBoolean;
	}
	public Byte getvByte() {
		return vByte;
	}
	public void setvByte(Byte vByte) {
		this.vByte = vByte;
	}
	public Short getvShort() {
		return vShort;
	}
	public void setvShort(Short vShort) {
		this.vShort = vShort;
	}
	public int getvInteger() {
		return vInteger;
	}
	public void setvInteger(int vInteger) {
		this.vInteger = vInteger;
	}
	public Long getvLong() {
		return vLong;
	}
	public void setvLong(Long vLong) {
		this.vLong = vLong;
	}
	public Double getvDouble() {
		return vDouble;
	}
	public void setvDouble(Double vDouble) {
		this.vDouble = vDouble;
	}
	public Float getvFloat() {
		return vFloat;
	}
	public void setvFloat(Float vFloat) {
		this.vFloat = vFloat;
	}
	public String getvString() {
		return vString;
	}
	public void setvString(String vString) {
		this.vString = vString;
	}
	public Character getvCharacter() {
		return vCharacter;
	}
	public void setvCharacter(Character vCharacter) {
		this.vCharacter = vCharacter;
	}
	/*@Override
	public String toString() {
		return "PrimitiveBean [vBoolean=" + vBoolean + ", vByte=" + vByte
				+ ", vShort=" + vShort + ", vInteger=" + vInteger + ", vLong="
				+ vLong + ", vDouble=" + vDouble + ", vFloat=" + vFloat
				+ ", vString=" + vString + ", vCharacter=" + vCharacter + "]";
	}*/
	@Override
	public String toString() {
		return "PrimitiveBean [vBoolean=" + vBoolean + ", vByte=" + vByte
				+ ", vShort=" + vShort + ", vInteger=" + vInteger + ", vLong="
				+ vLong + ", vDouble=" + vDouble + ", vFloat=" + vFloat
				+ ", vString=" + vString + ", vCharacter=" + vCharacter
				+ ", vMap=" + vMap + ", vList=" + vList + ", vSet=" + vSet
				+ "]";
	}
	
	
}
