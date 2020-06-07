package com.dbms.model;

public class Cart {
	
	private String username;
	private Long pid;
	private Long price;
	private Long quantity;
	private String ctype;
	private String color;
	private String name;
	private Long maxquan;
	
	public Long getMaxquan() {
		return maxquan;
	}

	public void setMaxquan(Long maxquan) {
		this.maxquan = maxquan;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cart() {
		
	}

	public Cart(String uname, Long pid, Long price, Long quan) {
		this.username=uname;
		this.pid=pid;
		this.price=price;
		this.quantity=quan;
		
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
}
