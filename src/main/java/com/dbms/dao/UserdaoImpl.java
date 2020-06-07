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

import com.dbms.model.User;

public class UserdaoImpl implements Userdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserdaoImpl() {
		
	}
	public UserdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void saveOrUpdate(User user) {
		 String sql = "INSERT INTO Login(username, password, role) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {user.getUsername(),user.getPassword(), "ROLE_USER"});
		 saveOrUpdateCustomer(user);
		 //System.out.println("EROOR");
		 System.out.println("EROOR");
	}
	
	@Transactional
	public void delete(String username) {
		String sql = "DELETE FROM Login WHERE username=?";
		jdbcTemplate.update(sql,username);
	}
	
	@Transactional
	public User getUser(String username) {
		String sql = "SELECT * FROM Login WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateCustomer(User user) {
		String sql="INSERT INTO Customer1(first_name, middle_name,last_name,shop_no,street_name,city,pincode,Email,phone_no,username) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {user.getFname(),user.getMname(),user.getLname(),user.getSno(),user.getStreetname(),user.getCity(),user.getPin(),user.getMail(),user.getPno(),user.getUsername()});
		
	}
	
	@Transactional
	public User getCustomer(String username) {
		String sql = "SELECT first_name,middle_name,last_name,shop_no,street_name,city,pincode,Email,phone_no,password FROM Customer1,Login u WHERE u.username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<User>() {
		
		public User extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				User user = new User();
				//user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMpassword(rs.getString("password"));
				user.setFname(rs.getString("first_name"));
				user.setMname(rs.getString("middle_name"));
				user.setLname(rs.getString("last_name"));
				user.setSno(rs.getString("shop_no"));
				user.setStreetname(rs.getString("street_name"));
				user.setPin(rs.getLong("pincode"));
				user.setCity(rs.getString("city"));
				user.setMail(rs.getString("Email"));
				user.setPno(rs.getLong("phone_no"));
				return user;
			}
			return null;
		}
		
	});
		
	}
	
	
	@Transactional
	public void userupdate(User user) {
		String sql = "update Customer1 set first_name=?,middle_name=?,last_name=?,shop_no=?,street_name=?,city=?,pincode=?,Email=?,phone_no=? where username=?";
		jdbcTemplate.update(sql, new Object[] {user.getFname(),user.getMname(),user.getLname(),user.getSno(),user.getStreetname(),user.getCity(),user.getPin(),user.getMail(),user.getPno(),user.getUsername()});
		String sqlt = "update Login set password=? where username=?";
		jdbcTemplate.update(sqlt, new Object[] {user.getPassword(),user.getUsername()});
		
	}
	
	@Transactional
	public List<User> dispuser(String username){
		String sql="select * from Customer1 where username = '"+username+"'";
		List <User> alluser=jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				User usr = new User();
				usr.setUsername(rs.getString("username"));
				usr.setFname(rs.getString("first_name"));
				usr.setMname(rs.getString("middle_name"));
				usr.setLname(rs.getString("last_name"));
				usr.setSno(rs.getString("shop_no"));
				usr.setStreetname(rs.getString("street_name"));
				usr.setCity(rs.getString("City"));
				usr.setPno(rs.getLong("phone_no"));
				usr.setMail(rs.getString("Email"));
				usr.setPin(rs.getLong("pincode"));
				return usr;
			}
			
		});
		return alluser;
	}
	
	@Transactional
	public String findRole(String username) {
		String sql = "select role from Login where username=?";
		String role = (String)jdbcTemplate.queryForObject(sql, new Object[] {username}, String.class);
		return role;
		
	}
	
}