package com.lzw.dao.model;

public class TbUser {
	private String name;
	private String password;
	public TbUser(){}
	public TbUser(String name){
		this.name = name;
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
		return "TbUser [name=" + name + ", password=" + password + "]";
	}
}
