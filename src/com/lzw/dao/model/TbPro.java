package com.lzw.dao.model;

public class TbPro {
	private String number;
	private String name;
	private String phone;
	private String mail;
	private String address;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "TbPro [number=" + number + ", name=" + name + ", phone=" + phone + ", mail=" + mail + ", address="
				+ address + "]";
	}
	
}
