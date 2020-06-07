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

import com.dbms.model.Manufacturer;

public class ManufacturerdaoImpl implements Manufacturerdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ManufacturerdaoImpl() {
		
	}
	
	public ManufacturerdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void delete(String name) {
		String sql = "DELETE FROM Manufacturer WHERE name=?";
		jdbcTemplate.update(sql,new Object[] {name});
	}
	
	@Transactional
	public Manufacturer getManufacturer(String name) {
		String sql = "SELECT * FROM Manufacturer WHERE name='"+name+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Manufacturer>() {
		
		public Manufacturer extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setName(rs.getString("name"));
				manufacturer.setSno(rs.getString("shop_no"));
				manufacturer.setStreetname(rs.getString("street_name"));
				manufacturer.setPin(rs.getLong("pincode"));
				manufacturer.setCity(rs.getString("city"));
				manufacturer.setWebsite(rs.getString("website"));
				manufacturer.setPno(rs.getLong("phone_no"));
				manufacturer.setMail(rs.getString("email"));
				manufacturer.setMid(rs.getLong("manufacturer_id"));
				return manufacturer;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	public void saveOrUpdateManufacturer(Manufacturer manufacturer) {
		String sql="INSERT INTO Manufacturer(name, website, shop_no,street_name,city,pincode,phone_no,email) VALUES(?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {manufacturer.getName(),manufacturer.getWebsite(),manufacturer.getSno(), manufacturer.getStreetname(),manufacturer.getCity(),manufacturer.getPin(),manufacturer.getPno(),manufacturer.getMail()});
		
	}
	
	@Transactional
	public void manufacupdate(Manufacturer manufacturer) {
		String sql = "update Manufacturer set website=?,shop_no=?,street_name=?,city=?,pincode=?,phone_no=?,email=? where name=?";
		jdbcTemplate.update(sql,new Object[] {manufacturer.getWebsite(),manufacturer.getSno(),manufacturer.getStreetname(),manufacturer.getCity(),manufacturer.getPin(),manufacturer.getPno(),manufacturer.getMail(),manufacturer.getName()});
		
		
	}
	
	@Transactional
	public List<Manufacturer> dispManufac(){
		String sql="select * from Manufacturer";
		List<Manufacturer> allmanufac = jdbcTemplate.query(sql, new RowMapper<Manufacturer>(){
		@Override
		public Manufacturer mapRow(ResultSet rs, int rowNum) throws SQLException{
			Manufacturer manufacturer=new Manufacturer();
			manufacturer.setName(rs.getString("name"));
			manufacturer.setMid(rs.getLong("manufacturer_id"));
			manufacturer.setSno(rs.getString("shop_no"));
			manufacturer.setStreetname(rs.getString("street_name"));
			manufacturer.setPin(rs.getLong("pincode"));
			manufacturer.setCity(rs.getString("city"));
			manufacturer.setWebsite(rs.getString("website"));
			manufacturer.setPno(rs.getLong("phone_no"));
			manufacturer.setMail(rs.getString("email"));
			return manufacturer;
			
		}
		});
		return allmanufac;
	}
	
}
