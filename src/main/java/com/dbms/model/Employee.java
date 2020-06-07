package com.dbms.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Employee {
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
	private String hno;
	//@NotEmpty(message="required")
	private Long pin;
	private String city;
	private Long salary;
	private String streetname;
	private Long pno;
	private Long emp_id;
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	public Employee() {
		
	}
	public Employee(String uname, String pass, String mpass, String fname, String mname, String lname, String hno, Long pin, String city, String streetname, Long salary, Long pno) {
		this.username=uname;
		this.password=pass;
		this.mpassword=mpass;
		this.fname=fname;
		this.mname=mname;
		this.lname=lname;
		this.city=city;
		this.hno=hno;
		this.pin=pin;
		this.streetname=streetname;
		this.salary=salary;
		this.pno=pno;
	}
	public Long getPno() {
		return pno;
	}
	public void setPno(Long pno) {
		this.pno = pno;
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
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
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
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getStreetname() {
		return streetname;
	}
	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}
	
}
