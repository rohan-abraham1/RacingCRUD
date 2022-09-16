package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.DTO.TeamDtoGet;
import com.example.demo.DTO.TeamDtoPost;
import com.example.demo.DTO.TeamDtoUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Team;

public interface TeamServiceInterface {
	public Set<Team> getTeamByEngineID(Long engineId);
	public List<Team> getAllTeams();
	public TeamDtoGet getTeamId(Long id) throws ResourceNotFoundException;
	public Team saveTeam(Long engineId, TeamDtoPost teamDto) throws ResourceNotFoundException;
	public void deleteTheTeam(Long id) throws ResourceNotFoundException;
	public Team updateTheTeam(Long engineId, Long id, TeamDtoUpdate teamDto) throws ResourceNotFoundException;
}
