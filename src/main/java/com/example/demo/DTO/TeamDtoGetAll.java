package com.example.demo.DTO;

import java.util.List;

import com.example.demo.model.Team;

public class TeamDtoGetAll extends TeamDtoPost {
	
	private List<Team> teamList;

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
}
