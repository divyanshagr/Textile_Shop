package com.dbms.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Manufacturer {
	@NotEmpty(message="required")
	private String name;
	private String website;
	private String sno;
	//@NotEmpty(message="required")
	private Long pin;
	private String city;
	private String streetname;
	private Long pno;
	private Long mid;
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	@Email(message="Invalid mail")
	private String mail;
	
	public Manufacturer() {
		
	}
	public Manufacturer(String name, String website, String sno, Long pin, String city, String streetname, Long pno, String mail) {
		this.name=name;
		this.website=website;
		this.city=city;
		this.sno=sno;
		this.pin=pin;
		this.streetname=streetname;
		this.pno=pno;
		this.mail=mail;
	}
	public Long getPno() {
		return pno;
	}
	public void setPno(Long pno) {
		this.pno = pno;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
	
}
