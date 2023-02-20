package com.itstep.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itstep.demo.enity.Department;
import com.itstep.demo.enity.Employee;
import com.itstep.demo.enity.ParkingSpace;
import com.itstep.demo.repo.IGenericRepo;

@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {
	
	@Autowired
	IGenericRepo<Employee> empRepo;
	
	@Autowired
	IGenericRepo<ParkingSpace> parkingRepo;
	

	@GetMapping(value = "/create")
	public void create () {
		var emp = new Employee("Sokna", 500);
		var parkSpace = new ParkingSpace("Location 1");
		var department = new Department("Information Technology");
		
		emp.setParkingSpace(parkSpace);
		emp.setDepartment(department);
		
		empRepo.save(emp);
	}
	
	@GetMapping(value="/find")
	public String find() {
		var list = empRepo.findAll();
		String temp = "";
		for (Employee employee : list) {
			temp += employee.getParkingSpace().getLocation() + " ";
		}
		
		return temp;
	}
	
	@GetMapping(value = "/pspace/find")
	public String findAllParkingSpace() {
		var list = parkingRepo.findAll();
		String temp = "";
		for (var park : list) {
			temp += park.getEmployee().getName() + " ";
		}
		
		return temp;
	}
}
