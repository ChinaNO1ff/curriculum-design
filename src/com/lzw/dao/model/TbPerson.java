package com.lzw.dao.model;

public class TbPerson {
	private int ID;
	private String name;
	private String message;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String toString() {
		return "TbPerson [ID=" + ID + ", name=" + name + ", message=" + message + "]";
	}
	
}
