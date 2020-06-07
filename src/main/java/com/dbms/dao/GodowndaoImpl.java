package com.dbms.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Godown;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
public class GodowndaoImpl implements Godowndao{
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public GodowndaoImpl() {
		
	}
	
	public GodowndaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public List<Godown> dispGodown(){
		String sql="select * from Godown";
		List<Godown> allgodown =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Godown>(Godown.class));
		return allgodown;
	}
	
	@Transactional
	public void delete(Long gid) {
		String sql = "DELETE FROM Godown where gid=?";
		jdbcTemplate.update(sql,gid);
	}
	
	@Transactional
	public Godown getGodown(Long gid) {
		String sql = "SELECT * FROM Godown WHERE gid='"+gid+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Godown>() {
		
		public Godown extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Godown godown = new Godown();
				godown.setStreet_name(rs.getString("street_name"));
				godown.setGid(rs.getLong("gid"));
				godown.setShop_no(rs.getString("shop_no"));
				godown.setCity(rs.getString("city"));
				godown.setPincode(rs.getLong("pincode"));
				return godown;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	public void saveGodown(Godown godown) {
		String sql="INSERT INTO Godown(shop_no,street_name,city,pincode) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {godown.getShop_no(),godown.getStreet_name(),godown.getCity(),godown.getPincode()});
		
	}
		
	@Transactional
	public void updateGodown(Godown godown) {
		String sql="Update Godown set shop_no=?,street_name=?,city=?,pincode=? where gid=?";
		jdbcTemplate.update(sql,new Object[] {godown.getShop_no(),godown.getStreet_name(),godown.getCity(),godown.getPincode(),godown.getGid()});
	}
	
}
