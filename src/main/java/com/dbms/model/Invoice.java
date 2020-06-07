package com.dbms.model;

import java.sql.Date;

public class Invoice {
	private Long inv_id;
	private String username;
	private Date dog;
	private Long amount;
	private Long pid;
	private Long quantity;
	private Long price;
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Invoice() {
		
		
	}
	public Invoice(Long inv_id,String uname, Date dog, Long amt, Long pid, Long quan) {
		this.amount=amt;
		this.inv_id=inv_id;
		this.username=uname;
		this.pid=pid;
		this.quantity=quan;
		this.dog=dog;
	}
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getInv_id() {
		return inv_id;
	}
	public void setInv_id(Long inv_id) {
		this.inv_id = inv_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDog() {
		return dog;
	}
	public void setDog(Date dog) {
		this.dog = dog;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
}
