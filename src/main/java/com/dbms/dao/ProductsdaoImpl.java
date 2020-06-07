package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Products;

public class ProductsdaoImpl implements Productsdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductsdaoImpl() {
		
	}
	
	public ProductsdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void delete(Long product_id) {
		String sql = "DELETE FROM Products WHERE product_id=?";
		jdbcTemplate.update(sql,new Object[] {product_id});
	}
	
	@Transactional
	public Products getProducts(Long product_id) {
		String sql = "SELECT * FROM Products WHERE product_id='"+product_id+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Products>() {
		
		public Products extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Products products = new Products();
				products.setName(rs.getString("name"));
				products.setMid(rs.getLong("manufactured_by"));
				products.setCtype(rs.getString("cloth_type"));
				products.setColor(rs.getString("color"));
				products.setBprice(rs.getLong("buy_price"));
				products.setSprice(rs.getLong("sell_price"));
				products.setQuantity(rs.getLong("quantity"));
				products.setProduct_id(rs.getLong("product_id"));
				return products;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	public void produpdate(Products products) {
		String sql = "update Products set manufactured_by=?,cloth_type=?,color=?,buy_price=?,sell_price=?,quantity=?,name=?,gid=? where product_id=?";
		jdbcTemplate.update(sql, new Object[] {products.getMid(),products.getCtype(),products.getColor(),products.getBprice(),products.getSprice(),products.getQuantity(),products.getName(),products.getGid(),products.getProduct_id() });

	}
	
	@Transactional
	public List<Products> dispProducts(){
		String sql="select * from Products";
		List<Products> allprod = jdbcTemplate.query(sql, new RowMapper<Products>(){
		@Override
		public Products mapRow(ResultSet rs, int rowNum) throws SQLException{
			Products products = new Products();
			products.setName(rs.getString("name"));
			products.setMid(rs.getLong("manufactured_by"));
			products.setCtype(rs.getString("cloth_type"));
			products.setColor(rs.getString("color"));
			products.setBprice(rs.getLong("buy_price"));
			products.setSprice(rs.getLong("sell_price"));
			products.setQuantity(rs.getLong("quantity"));
			products.setProduct_id(rs.getLong("product_id"));
			products.setGid(rs.getLong("gid"));
			return products;
			
		}
		});
		return allprod;
	}
	
	@Transactional
	public void saveOrUpdateProducts(Products products) {
		String sql="INSERT INTO Products(manufactured_by, name, cloth_type, color, buy_price, sell_price, quantity,gid) VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {products.getMid(),products.getName(),products.getCtype(),products.getColor(),products.getBprice(), products.getSprice(),products.getQuantity(),products.getGid()});
		
	}
		
	
	
}
