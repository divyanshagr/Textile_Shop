package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Cart;

public class CartdaoImpl implements Cartdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CartdaoImpl() {
		
	}
	
	public CartdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void saveOrUpdate(String username,Long pid) {
		String sql="select sell_price from Products where product_id=?";
		Long Price=(Long)jdbcTemplate.queryForObject(sql,new Object[] {pid}, Long.class);
		String sql2 = "SELECT count(*) FROM Cart WHERE username = ? and product_id=?";
		int count = (Integer)jdbcTemplate.queryForObject(sql2, new Object[] { username,pid }, Integer.class);
		if(count==0) {
			String sql3="insert into Cart(username,product_id,price,quantity) values(?,?,?,?)";
			jdbcTemplate.update(sql3, new Object[] {username, pid, Price, 1});
		}
		else {
			String sql4="update Cart set quantity=quantity+1 where username=? and product_id=?";
			jdbcTemplate.update(sql4,new Object[] {username,pid});
		}
	}
	
	@Transactional
	public List<Cart> viewCart(String username){
		
		String sql="select p.name,p.product_id,c.price,p.color,p.cloth_type,c.quantity from Products p, Cart c where c.username='"+username+"' and p.product_id=c.product_id";
		List<Cart> allcart = jdbcTemplate.query(sql, new RowMapper<Cart>() {
			@Override
			public Cart mapRow(ResultSet rs, int rowNum) throws SQLException{
				Cart cart=new Cart();
				cart.setName(rs.getString("name"));
				cart.setPid(rs.getLong("product_id"));
				cart.setQuantity(rs.getLong("quantity"));
				cart.setColor(rs.getString("color"));
				cart.setCtype(rs.getString("cloth_type"));
				cart.setPrice(rs.getLong("price"));
				cart.setMaxquan(getMaxquan(cart.getPid()));
				return cart;
			}
		});
		return allcart;
	}
	
	@Transactional
	public void deleteEntry(String username, Long pid) {
		String sql = "delete from Cart where username=? and product_id=?";
		jdbcTemplate.update(sql,new Object[] {username,pid});
		
	}
	
	@Transactional
	public Long totalPrice(String username) {
		String sql="select sum(quantity*price) from Cart where username=? group by username";
		try{Long Price = (Long)jdbcTemplate.queryForObject(sql, new Object[] { username}, Long.class);
		return Price;}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		
	}
	
	@Transactional
	public Long getMaxquan(Long pid) {
		String sql="select quantity from Products where product_id=?";
		Long quan = (Long)jdbcTemplate.queryForObject(sql, new Object[] {pid}, Long.class);
		return quan;
		
	}
	
	@Transactional
	public void updateEntry(Cart cart) {
		String sql="update Cart set quantity=? where username=? and product_id=?";
		jdbcTemplate.update(sql,new Object[] {cart.getQuantity(),cart.getUsername(),cart.getPid()});
	}
	
}
