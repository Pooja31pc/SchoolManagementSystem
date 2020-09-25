package com.simplilearn.model;

public class Grade {

	private int gid;
	private String standard;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public Grade(int gid, String standard) {
		super();
		this.gid = gid;
		this.standard = standard;
	}
	public Grade(String standard) {
		super();
		this.standard = standard;
	}
	
	
	
	
}
