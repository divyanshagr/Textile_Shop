package com.dbms.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User{
	@NotEmpty(message="required")
	private String username;
	@NotEmpty(message="required")
	private String password;
	@NotEmpty(message="required")
	private String mpassword;
	@NotEmpty(message="required")
	private String fname;
	private String mname;
	private String lname;
	
	private String sno;
	//@NotEmpty(message="required")
	private Long pin;
	@NotEmpty(message="required")
	private String city;
	
	private String streetname;
	@Email(message="Invalid mail")
	private String mail;
	private Long pno;
	


	public User() {
		
	}
	
	public User(String uname, String pass, String mpass, String fname, String mname, String lname, String sno, Long pin, String city, String streetname, String mail, Long phno) {
		this.username=uname;
		this.password=pass;
		this.mpassword=mpass;
		this.fname=fname;
		this.mname=mname;
		this.lname=lname;
		this.city=city;
		this.sno=sno;
		this.pin=pin;
		this.streetname=streetname;
		this.mail=mail;
		this.pno=phno;
	}
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getPno() {
		return pno;
	}

	public void setPno(Long pno) {
		this.pno = pno;
	}
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public User(String uname,String pass) {
		this.username=uname;
		this.password=pass;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
	
}