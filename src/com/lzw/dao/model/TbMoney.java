package com.lzw.dao.model;

public class TbMoney {
	private String number;
	private float out;
	private float in;
	private float gain;
	private float total;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public float getOut() {
		return out;
	}
	public void setOut(float out) {
		this.out = out;
	}
	public float getIn() {
		return in;
	}
	public void setIn(float in) {
		this.in = in;
	}
	public float getGain() {
		return gain;
	}
	public void setGain(float gain) {
		this.gain = gain;
	}
	public float getTotal() {
		return total;
	}
	
	public String toString() {
		return "TbMoney [number=" + number + ", out=" + out + ", in=" + in + ", gain=" + gain + ", total=" + total
				+ "]";
	}
	
}
