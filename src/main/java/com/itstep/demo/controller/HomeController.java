package com.itstep.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itstep.demo.enity.Employee;
import com.itstep.demo.repo.EmployeeRepo;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeRepo empRepo;

	@GetMapping(value = "/hello")
	@ResponseBody
	public String hello() {
		return "Hello it's working.";
	}
	
	@GetMapping("/post")
	@ResponseBody
	public String postEmployee() {
		Employee emp = new Employee("Dara", 1000);
		empRepo.save(emp);
		
		return "Okay";
	}
	@GetMapping("/employee/{id}")
	@ResponseBody
	public String getEmplee(@PathVariable("id") int id) throws JsonProcessingException {
		var emp = empRepo.find(id);
		
		
		var json = new ObjectMapper().writeValueAsString(emp);
		
		return json;
	}
}



