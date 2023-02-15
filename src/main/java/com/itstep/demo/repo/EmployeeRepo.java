package com.itstep.demo.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.itstep.demo.enity.Employee;

@Repository
@Transactional
public class EmployeeRepo {

	@PersistenceContext
	EntityManager manager;
	
	public void save(Employee emp) {
		manager.persist(emp);
	}
	
	public Employee find(int id) {
		
		return manager.find(Employee.class, id);
	}
}
