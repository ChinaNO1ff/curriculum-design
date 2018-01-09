package com.lzw.dao.model;

public class TbStore {
	private String number;
	private String name;
	private float unit;
	private int count;
	private String type;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getUnit() {
		return unit;
	}
	public void setUnit(float unit) {
		this.unit = unit;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "TbStore [number=" + number + ", name=" + name + ", unit=" + unit + ", count=" + count + ", type=" + type
				+ "]";
	}
	
}
