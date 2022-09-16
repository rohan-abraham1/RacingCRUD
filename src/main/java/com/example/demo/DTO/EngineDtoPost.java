package com.example.demo.DTO;

public class EngineDtoPost {
	private Long id;
	private String name;
	private String hqLocation;
	
	public EngineDtoPost(Long id, String name, String hqLocation) {
		this.id = id;
		this.name = name;
		this.hqLocation = hqLocation;
	}
	
	public EngineDtoPost() {
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
