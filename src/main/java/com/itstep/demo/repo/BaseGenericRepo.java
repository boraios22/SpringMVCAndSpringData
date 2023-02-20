package com.itstep.demo.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseGenericRepo<T> {
	@PersistenceContext
	EntityManager manager;
	
	protected void saveEntity(T entity) {
		manager.persist(entity);
	}
	
	protected void updateEntity(T entity) {
		manager.merge(entity);
	}
	
	protected T findEntityById(Class<T> type, int id) {
		return manager.find(type, id);
	}
	
	protected void deleteEntity(Class<T> type, int id) {
		var ref = manager.getReference(type, id);
		manager.remove(ref);
	}
	
	protected List<T> findAllEntity(Class<T> type, String query) {
		return manager.createQuery(query, type).getResultList();
	}
	
}
