package com.lzw.dao.model;

public class TbUser {
	private int ID;
	private String name;
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String toString() {
		return "TbUser [ID=" + ID + ", name=" + name + ", password=" + password + "]";
	}
}
