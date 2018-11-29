package com.chinaedu.entity;

public class Dept {
	private String  name;
	private int no;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Dept [name=" + name + ", no=" + no + "]";
	}
	

}
