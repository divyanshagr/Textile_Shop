package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Cart;

public interface Cartdao {
	
	@Autowired
	public void saveOrUpdate(String username, Long pid);
	public List<Cart> viewCart(String username);
	public void deleteEntry(String username, Long pid);
	public Long totalPrice(String username);
	public Long getMaxquan(Long pid);
	public void updateEntry(Cart cart);
}
