package com.simplilearn.model;

public class TeacherSubjectGrade {

	private String subjectName;
	private String firstName;
	private String lastName;
	private String standard;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public TeacherSubjectGrade(String subjectName, String firstName, String lastName, String standard) {

		this.subjectName = subjectName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.standard = standard;
	}

}
