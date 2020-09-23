package com.simplilearn.model;

public class Subject {

	private int sid;
	private String subjectName;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
	public Subject(int sid, String subjectName) {
		super();
		this.sid = sid;
		this.subjectName = subjectName;
	}
	
	
	public Subject(String subjectName) {
		super();
		this.subjectName = subjectName;
	}
	
	
	
}
