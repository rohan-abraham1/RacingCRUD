package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "engine")
	@JsonIgnore
	 private List<Team> teams = new ArrayList<>();
	
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
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
}
