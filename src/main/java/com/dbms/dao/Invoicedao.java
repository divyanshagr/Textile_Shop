package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Cart;
import com.dbms.model.Invoice;

public interface Invoicedao {
	@Autowired
	public List<Invoice> updateInvoiceentry(String username, Long amount, List<Cart> clist,Integer inv_id);
	public Integer updateInvoice(String username, Long amount);
	public List<Invoice> dispInvoice(Integer inv_id); 
	public List<Invoice> dispEntry(Integer inv_id);
	public List<Invoice> dispAllinv();
	public String findUser(Integer inv_id);
}
