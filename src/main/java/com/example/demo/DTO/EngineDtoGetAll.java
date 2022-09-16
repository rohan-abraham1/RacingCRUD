package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Engine;

public class EngineDtoGetAll extends EngineDtoPost {
	
	private List<Engine> engineList;

	public EngineDtoGetAll(Long id, String name, String hqLocation) {
		super(id, name, hqLocation);
	}

	public EngineDtoGetAll(Long id, String name, String hqLocation, List<Engine> engineList) {
		super(id, name, hqLocation);
		this.engineList = engineList;
	}
	
	public EngineDtoGetAll() {
		super();
	}

	public List<Engine> getEngineList() {
		return engineList;
	}

	public void setEngineList(List<Engine> engineList) {
		this.engineList = engineList;
	}

}
