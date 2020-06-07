package com.dbms.model;

import java.sql.Date;

public class Transportentry {
	
	private Long inv_id;
	private String address;
	private String city;
	private Long pincode;
	private Long phone_no;
	private Long tid;
	private Date dot;
	private String transdue;
	private String username;
	
	public Transportentry() {
		
	}

	public Long getInv_id() {
		return inv_id;
	}

	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}

	public Long getTid() {
		return tid;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}

	public Date getDot() {
		return dot;
	}

	public void setDot(Date dot) {
		this.dot = dot;
	}

	public String getTransdue() {
		return transdue;
	}

	public void setTransdue(String transdue) {
		this.transdue = transdue;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
