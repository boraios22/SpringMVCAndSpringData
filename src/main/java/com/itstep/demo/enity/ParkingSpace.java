package com.itstep.demo.enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARKING_SPACE")
public class ParkingSpace {
	@Id
	@Column(name="pspace_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String location;
	public ParkingSpace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParkingSpace(String location) {
		super();
		this.location = location;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
