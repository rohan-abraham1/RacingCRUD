package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "engine")
public class Engine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "hq_location")
	private String hqLocation;
	
	public Engine() {
	}
	public Engine(String name, String hqLocation) {
		this.name = name;
		this.hqLocation = hqLocation;
	}
	public Engine(Long id, String name, String hqLocation) {
		this.id = id;
		this.name = name;
		this.hqLocation = hqLocation;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHqLocation() {
		return hqLocation;
	}
	public void setHqLocation(String hqLocation) {
		this.hqLocation = hqLocation;
	}
}
