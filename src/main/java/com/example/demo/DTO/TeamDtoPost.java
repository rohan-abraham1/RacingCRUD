package com.example.demo.DTO;

public class TeamDtoPost {
	private Long id;
	private String name;
	private Integer trophies;
	
	public TeamDtoPost(Long id, String name, Integer trophies) {
		super();
		this.id = id;
		this.name = name;
		this.trophies = trophies;
	}
		
	public TeamDtoPost() {
		super();
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
	public Integer getTrophies() {
		return trophies;
	}
	public void setTrophies(Integer trophies) {
		this.trophies = trophies;
	}	
}
