package com.simplilearn.model;

public class Student {

	private int srno;
	private String firstName;
	private String lastName;
	private int clsId;
	
	
	public int getSrno() {
		return srno;
	}
	public void setSrno(int srno) {
		this.srno = srno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getClsId() {
		return clsId;
	}
	public void setClsId(int clsId) {
		this.clsId = clsId;
	}
	
	
	public Student(int srno, String firstName, String lastName, int clsId) {
		super();
		this.srno = srno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clsId = clsId;
	}
	
	
	public Student(String firstName, String lastName, int clsId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.clsId = clsId;
	}
	
	
	
	
}
