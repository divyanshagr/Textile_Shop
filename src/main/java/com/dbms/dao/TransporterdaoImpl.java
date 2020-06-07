package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Transporter;

public class TransporterdaoImpl implements Transporterdao {

	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public TransporterdaoImpl() {

	}

	public TransporterdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Transactional
	public void saveTransporter(Transporter transporter) {
		String sql = "insert into Transporter(name,address,city,phone_no,pincode) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { transporter.getName(), transporter.getAddress(), transporter.getCity(),
				transporter.getPhone_no(), transporter.getPincode() });
	}

	@Transactional
	public List<Transporter> dispTrans() {
		String sql = "select * from Transporter";
		List<Transporter> alltrans = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Transporter>(Transporter.class));
		return alltrans;
	}

	@Transactional
	public void delete(Long tid) {
		String sql = "DELETE FROM Transporter where tid =?";
		jdbcTemplate.update(sql, new Object[] { tid });
	}

	@Transactional
	public Transporter getTransporter(Long tid) {
		String sql = "SELECT * FROM Transporter WHERE tid='" + tid + "'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Transporter>() {

			public Transporter extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Transporter transporter = new Transporter();
					transporter.setName(rs.getString("name"));
					transporter.setAddress(rs.getString("address"));
					transporter.setCity(rs.getString("city"));
					transporter.setPhone_no(rs.getLong("phone_no"));
					transporter.setPincode(rs.getLong("pincode"));
					transporter.setTid(rs.getLong("tid"));
					return transporter;
				}
				return null;
			}

		});

	}

	@Transactional
	public void update(Transporter transporter) {
		String sql = "update Transporter set name=?,address=?,city=?, phone_no=?, pincode=? where tid=?";
		jdbcTemplate.update(sql, new Object[] { transporter.getName(), transporter.getAddress(), transporter.getCity(),
				transporter.getPhone_no(), transporter.getPincode(), transporter.getTid() });
	}
}
