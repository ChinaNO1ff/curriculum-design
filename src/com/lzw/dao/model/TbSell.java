package com.lzw.dao.model;

public class TbSell {
	private String number;
	private String name;
	private float unit;
	private int count;
	private float total;
	private String more;
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
	public String getMore() {
		return more;
	}
	public void setMore(String more) {
		this.more = more;
	}
	public float getTotal() {
		return total;
	}
	
	public String toString() {
		return "TbSell [number=" + number + ", name=" + name + ", unit=" + unit + ", count=" + count + ", total="
				+ total + ", more=" + more + "]";
	}
	
}
