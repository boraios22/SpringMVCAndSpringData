package com.itstep.demo.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.itstep.demo.enity.Employee;

@Repository
public class EmployeeJdbcRepo {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Employee> retieveAll(){
		return jdbcTemplate.query("select * from Employee", new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	public Employee findById(int id) {
		return jdbcTemplate.queryForObject("select * from Employee where emp_id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
	}
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from Employee where id=?", new Object[] {id});
	}
	public int update(Employee p) {
		return jdbcTemplate.update("update Employee set name=? where id=?", new Object[] {p.getName(), p.getId()});
	}
	public int insert(Employee p) {
		return jdbcTemplate.update("insert into Employee(name, salary) values(?,?)", new Object[] {p.getName(), p.getSalary()});
	}

	
}
