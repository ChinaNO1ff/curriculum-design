package com.lzw.dao.model;

public class TbBuy {
	private String number;
	private String name;
	private float unit;
	private int count;
	private float total;
	private int person;
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
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getTotal() {
		return total;
	}
	
	public String toString() {
		return "TbBuy [number=" + number + ", name=" + name + ", unit=" + unit + ", count=" + count + ", total=" + total
				+ ", person=" + person + ", type=" + type + "]";
	}
	
}
