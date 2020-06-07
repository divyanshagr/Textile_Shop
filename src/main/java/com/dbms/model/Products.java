package com.dbms.model;



public class Products {
	private String name;
	private String color;
	private Long bprice;
	private Long sprice;
	private Long quantity;
	private String ctype;
	private Long mid;
	private Long product_id;
	private Long gid;
	public Products() {
		
	}
	public Products(Long mid, String pname, String type,String color, Long bp, Long sp, Long quan,Long product_id) {
		this.name=pname;
		this.color=color;
		this.bprice=bp;
		this.sprice=sp;
		this.ctype=type;
		this.quantity=quan;
		this.mid=mid;
		this.product_id=product_id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getBprice() {
		return bprice;
	}
	public void setBprice(Long bprice) {
		this.bprice = bprice;
	}
	public Long getSprice() {
		return sprice;
	}
	public void setSprice(Long sprice) {
		this.sprice = sprice;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	
	
}
