package com.dbms.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Transportentry;

public class TransportentrydaoImpl implements Transportentrydao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TransportentrydaoImpl() {
		
	}
	
	public TransportentrydaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void saveEntry(Transportentry transportentry, Integer inv_id) {
			String sql = "insert into Transportentry(inv_id, address, city, pincode, phone_no, transdue) values(?,?,?,?,?,?)";
			jdbcTemplate.update(sql, new Object[] {inv_id, transportentry.getAddress(),transportentry.getCity(),transportentry.getPincode(),transportentry.getPhone_no(),"NO"});
		
	}
	
	@Transactional
	public void updateEntry(Transportentry transportentry, String transdue) {
		String sql = "update Transportentry set tid=?, dot=?, transdue=? where inv_id=?";
		jdbcTemplate.update(sql, new Object[] {transportentry.getTid(),transportentry.getDot(),transdue,transportentry.getInv_id()});
		
	}
	
	@Transactional
	public List<Transportentry> dispEntry(String transdue){
		String sql=" select * from Transportentry where transdue='"+transdue+"'";
		List<Transportentry> allentry =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Transportentry>(Transportentry.class));
		return allentry;
	}
	
	
}