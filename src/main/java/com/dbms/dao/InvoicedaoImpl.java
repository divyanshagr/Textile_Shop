package com.dbms.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Cart;
import com.dbms.model.Invoice;

public class InvoicedaoImpl implements Invoicedao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public InvoicedaoImpl() {
		
	}
	
	public InvoicedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public Integer updateInvoice(String username, Long amount) {
		String sql="insert into Invoice(username,DOG,amount) values(?,?,?)";
		long millis=System.currentTimeMillis();  
		Date date=new Date(millis); 
		jdbcTemplate.update(sql, new Object[] {username,date,amount});
		String sql1="select invoice_id from Invoice where username = ? order by invoice_id desc limit 1";
		Integer invoice_id=(Integer)jdbcTemplate.queryForObject(sql1, new Object[] {username},Integer.class);
		return invoice_id;
	}
	
	@Transactional
	public List<Invoice> updateInvoiceentry(String username, Long amount, List<Cart> clist, Integer inv_id) {
		
		for(Cart c:clist) {
			String sql2="insert into Inv_entry values(?,?,?,?)";
			jdbcTemplate.update(sql2, new Object[] {inv_id,c.getPid(),c.getQuantity(),c.getPrice()});
			String sql3="Delete from Cart where username=? and product_id=?";
			jdbcTemplate.update(sql3, new Object[] {username,c.getPid()});
			String sql4 = "update Products set quantity=quantity-? where product_id = ?";
			jdbcTemplate.update(sql4,new Object[] {c.getQuantity(),c.getPid()});
		}
		List<Invoice> allent = dispEntry(inv_id);
		return allent;
	}
	
	@Transactional
	public List<Invoice> dispInvoice(Integer inv_id){
		
		String sql="select * from Invoice where invoice_id = '"+inv_id+"'";
		List<Invoice> allinv = jdbcTemplate.query(sql, new RowMapper<Invoice>() {
			@Override
			public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException{
				Invoice invoice=new Invoice();
				invoice.setInv_id(rs.getLong("invoice_id"));
				invoice.setUsername(rs.getString("username"));
				invoice.setDog(rs.getDate("DOG"));
				invoice.setAmount(rs.getLong("amount"));
				
				return invoice;		
			}
			});
			return allinv;
		}
	
	@Transactional
	public List<Invoice> dispEntry(Integer inv_id){
		String sql="select * from Inv_entry where invoice_id='"+inv_id+"'";
		List<Invoice> allentry = jdbcTemplate.query(sql, new RowMapper<Invoice>() {
			@Override
			public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException{
				Invoice invoice=new Invoice();
				invoice.setInv_id(rs.getLong("invoice_id"));
				invoice.setPid(rs.getLong("pid"));
				invoice.setQuantity(rs.getLong("quantity"));
				invoice.setPrice(rs.getLong("price"));
				return invoice;		
			}
			});
			return allentry;
		
	}
	
	@Transactional
	public List<Invoice> dispAllinv(){
		
		String sql="select * from Invoice";
		List<Invoice> allinv = jdbcTemplate.query(sql, new RowMapper<Invoice>() {
			@Override
			public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException{
				Invoice invoice=new Invoice();
				invoice.setInv_id(rs.getLong("invoice_id"));
				invoice.setUsername(rs.getString("username"));
				invoice.setDog(rs.getDate("DOG"));
				invoice.setAmount(rs.getLong("amount"));
				
				return invoice;		
			}
			});
			return allinv;
		}
	
	@Transactional
	public String findUser(Integer inv_id) {
		String sql = "select username from Invoice where invoice_id=?";
		String username=(String)jdbcTemplate.queryForObject(sql, new Object[] {inv_id}, String.class);
		return username;
	}
}