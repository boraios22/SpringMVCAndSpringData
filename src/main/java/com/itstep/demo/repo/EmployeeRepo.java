package com.itstep.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.itstep.demo.enity.Employee;

@Repository
@Transactional
public class EmployeeRepo extends 
BaseGenericRepo<Employee> implements 
IGenericRepo<Employee>{

	@Override
	public void save(Employee entity) {
		this.saveEntity(entity);
	}

	@Override
	public void update(Employee entity) {
		this.updateEntity(entity);
	}

	@Override
	public Employee findById(int id) {
		return this.findEntityById(Employee.class, id);
	}

	@Override
	public void delete(int id) {
		this.deleteEntity(Employee.class, id);
	}

	@Override
	public List<Employee> findAll() {
		return this.findAllEntity(Employee.class, "from Employee");
	}

	/*@PersistenceContext
	EntityManager manager;
	
	public void save(Employee emp) {
		manager.persist(emp);
	}
	
	public Employee find(int id) {
		return manager.find(Employee.class, id);
	}
	public List<Employee> findAll() {
		return manager.createQuery("from Employee", Employee.class).getResultList();
	}*/

}

