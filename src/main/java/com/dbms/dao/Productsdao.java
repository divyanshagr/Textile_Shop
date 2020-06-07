package com.dbms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.dbms.model.Products;

public interface Productsdao {
	@Autowired
	public void delete(Long product_id);
	public Products getProducts(Long product_id);
	public void saveOrUpdateProducts(Products products);
	public List<Products> dispProducts();
	public void produpdate(Products prodcuts);
}
