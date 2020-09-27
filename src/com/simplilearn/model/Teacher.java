package com.simplilearn.model;

public class Teacher {

	private int srno;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Teacher(int srno, String firstName, String lastName, String gender, int age) {

		this.srno = srno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	public Teacher(String firstName, String lastName, String gender, int age) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

}
