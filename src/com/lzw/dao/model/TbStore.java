package com.lzw.dao.model;

public class TbStore {
	private String name;
	private int count;
	public TbStore(){}
	public TbStore(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return "TbStore [name=" + name + ", count=" + count + "]";
	}
	
}
