package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.TeamDtoGet;
import com.example.demo.DTO.TeamDtoPost;
import com.example.demo.DTO.TeamDtoUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Team;

public interface TeamServiceInterface {
	public List<Team> getTeamByEngineID(Long engineId) throws ResourceNotFoundException;
	public List<Team> getAllTeams();
	public TeamDtoGet getTeamId(Long id) throws ResourceNotFoundException;
	public Team saveTeam(Long engineId, TeamDtoPost teamDto) throws ResourceNotFoundException;
	public void deleteTheTeam(Long id) throws ResourceNotFoundException;
	public Team updateTheTeam(Long engineId, Long id, TeamDtoUpdate teamDto) throws ResourceNotFoundException;
}
