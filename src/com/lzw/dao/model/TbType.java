package com.lzw.dao.model;

public class TbType {
	private String ID;
	private String type;
	private String name;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "TbType [ID=" + ID + ", type=" + type + ", name=" + name + "]";
	}
}
