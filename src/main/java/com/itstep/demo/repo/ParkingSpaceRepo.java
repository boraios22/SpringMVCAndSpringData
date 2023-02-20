package com.itstep.demo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.itstep.demo.enity.ParkingSpace;

@Repository
@Transactional
public class ParkingSpaceRepo extends BaseGenericRepo<ParkingSpace> implements IGenericRepo<ParkingSpace> {

	@Override
	public void save(ParkingSpace entity) {
		this.saveEntity(entity);
	}

	@Override
	public void update(ParkingSpace entity) {
		this.updateEntity(entity);
	}

	@Override
	public ParkingSpace findById(int id) {
		return this.findEntityById(ParkingSpace.class, id);
	}

	@Override
	public void delete(int id) {
		this.deleteEntity(ParkingSpace.class, id);
	}

	@Override
	public List<ParkingSpace> findAll() {
		return this.findAllEntity(ParkingSpace.class, "from ParkingSpace");
	}

}
