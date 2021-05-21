package com.example.demo.repositeries;

import java.sql.ResultSet;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository
public class EmployeeRepositeries {

		@Autowired
		JdbcTemplate jdbcTemplate;
		
		private final String GET_ALL = "Select * from test";
		private final String INSERT_EMPLOYEE = "INSERT into TEST(BLOG_ID,BLOG_NAME,Author) values (?,?,?)";
		private final String UPDATE_EMPLOYEE = "UPDATE test set BLOG_NAME = ?,Author = ? WHERE BLOG_ID = ?";
		private final String DELETE_EMPLOYEE = "DELETE test where BLOG_ID = ?";
		
		private RowMapper<Employee> rowMapper = (ResultSet rs,int rowNum) -> {
			Employee emp = new Employee();
	
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setAuthor(rs.getString(3));
			emp.setPubdate(rs.getString(4));
			return emp;
		};
		public List<Employee> findAll() {
			return jdbcTemplate.query(GET_ALL, rowMapper);
		}
		public boolean addEmployee(Employee e) {
			if(jdbcTemplate.update(INSERT_EMPLOYEE,e.getId(),e.getName(),e.getAuthor())>0)
				return true;
			else
				return false;
		}
		public boolean updateEmployee(Employee e) {
			if(jdbcTemplate.update(UPDATE_EMPLOYEE, e.getName(),e.getAuthor(),e.getId())>0)
				return true;
			else
				return false;
		}
		public boolean deleteEmployee(int id) {
			if(jdbcTemplate.update(DELETE_EMPLOYEE,id)>0)
				return true;
			else
				return false;
		}
		public List<Employee> get_d_ID(int id) {
			return jdbcTemplate.query("Select * from test WHERE BLOG_ID ="+id, rowMapper);
		}
}
