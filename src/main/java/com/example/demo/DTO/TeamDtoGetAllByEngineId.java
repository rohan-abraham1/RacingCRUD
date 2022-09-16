package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Team;

public class TeamDtoGetAllByEngineId extends TeamDtoPost {
	
	private List<Team> teamInEngine;

	public List<Team> getTeamInEngine() {
		return teamInEngine;
	}

	public void setTeamInEngine(List<Team> teamInEngine) {
		this.teamInEngine = teamInEngine;
	}
}
