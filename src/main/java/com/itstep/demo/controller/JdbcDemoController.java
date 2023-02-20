package com.itstep.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itstep.demo.enity.Employee;
import com.itstep.demo.repo.EmployeeJdbcRepo;

@RestController
public class JdbcDemoController {
	
	@Autowired
	EmployeeJdbcRepo empRepo;
	
	@GetMapping(value="/emp/create")
	public String create() {
		var emp = new Employee("Soknim", 2000);
		empRepo.insert(emp);
		
		return "Inserted successfully";
	}
	
	@GetMapping(value="/emp/{id}")
	public String find(@PathVariable("id") int id) throws JsonProcessingException {
		var emp = empRepo.findById(id);
		var json = new ObjectMapper().writeValueAsString(emp);
		
		return json;
	}
}
