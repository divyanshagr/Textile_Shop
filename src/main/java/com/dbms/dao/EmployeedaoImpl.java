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

import com.dbms.model.Employee;

public class EmployeedaoImpl implements Employeedao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeedaoImpl() {
		
	}
	
	public EmployeedaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Transactional
	public void saveOrUpdate(Employee employee) {
		 String sql = "INSERT INTO Login(username, password, role) VALUES (?,?,?)";
		 jdbcTemplate.update(sql,new Object[] {employee.getUsername(),employee.getPassword(), "ROLE_EMPLOYEE"});
		 saveOrUpdateEmployee(employee);
		 //System.out.println("EROOR");
		 System.out.println("EROOR");
	}
	
	@Transactional
	public void delete(String username) {
		String sql = "DELETE FROM Login WHERE username=?";
		jdbcTemplate.update(sql,new Object[] {username});
	}
	
	@Transactional
	public Employee getEmployeeUser(String username) {
		String sql = "SELECT * FROM Login WHERE username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Employee>() {
		
		public Employee extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Employee employee = new Employee();
				employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				return employee;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	public void saveOrUpdateEmployee(Employee employee) {
		String sql="INSERT INTO Employee(first_name, middle_name,last_name,house_no,street_name,city,pincode,salary,phone_no,username) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {employee.getFname(),employee.getMname(),employee.getLname(),employee.getHno(),employee.getStreetname(),employee.getCity(),employee.getPin(),employee.getSalary(),employee.getPno(),employee.getUsername()});
		
	}
	
	@Transactional
	public Employee getEmployee(String username) {
		String sql = "SELECT first_name,middle_name,last_name,house_no,street_name,city,salary,pincode,phone_no,password FROM Employee,Login l WHERE l.username='"+username+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Employee>() {
		
		public Employee extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Employee employee = new Employee();
			//	employee.setUsername(rs.getString("username"));
				employee.setPassword(rs.getString("password"));
				employee.setMpassword(rs.getString("password"));
				employee.setFname(rs.getString("first_name"));
				employee.setMname(rs.getString("middle_name"));
				employee.setLname(rs.getString("last_name"));
				employee.setHno(rs.getString("house_no"));
				employee.setStreetname(rs.getString("street_name"));
				employee.setPin(rs.getLong("pincode"));
				employee.setCity(rs.getString("city"));
				employee.setSalary(rs.getLong("salary"));
				employee.setPno(rs.getLong("phone_no"));
				return employee;
			}
			return null;
		}
		
	});
		
	}
	
	@Transactional
	public void empupdate(Employee employee) {
		String sql = "update Employee set first_name=?,middle_name=?,last_name=?, house_no=?, street_name=?, city=?, salary=?, pincode=?, phone_no=? where username=?";
		jdbcTemplate.update(sql,new Object[] {employee.getFname(),employee.getMname(),employee.getLname(),employee.getHno(),employee.getStreetname(),employee.getCity(),employee.getSalary(),employee.getPin(),employee.getPno(),employee.getUsername()});
		String sql1="update Login set password=? where username=?";
		jdbcTemplate.update(sql1, new Object[] { employee.getPassword(),employee.getUsername()});		
		
	}
	
	@Transactional
	public List<Employee> dispEmployee(){
		String sql="select * from Employee";
		List<Employee> allemp = jdbcTemplate.query(sql, new RowMapper<Employee>(){
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
			Employee employee=new Employee();
			employee.setUsername(rs.getString("username"));
			employee.setEmp_id(rs.getLong("emp_id"));
			employee.setFname(rs.getString("first_name"));
			employee.setMname(rs.getString("middle_name"));
			employee.setLname(rs.getString("last_name"));
			employee.setHno(rs.getString("house_no"));
			employee.setStreetname(rs.getString("street_name"));
			employee.setPin(rs.getLong("pincode"));
			employee.setCity(rs.getString("city"));
			employee.setSalary(rs.getLong("salary"));
			employee.setPno(rs.getLong("phone_no"));
			return employee;
			
		}
		});
		return allemp;
	}

	
}