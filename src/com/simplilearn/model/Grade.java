package com.simplilearn.model;

public class Grade {

	private int cid;
	private String standard;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
	public Grade(int cid, String standard) {
		super();
		this.cid = cid;
		this.standard = standard;
	}
	
	
	public Grade(String standard) {
		super();
		this.standard = standard;
	}
	
	
	
}
