package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Team;

public interface TeamServiceInterface {
	public Set<Team> getTeamByEngineID(Long engineId);
	public List<Team> getAllTeams();
	public ResponseEntity<Team> getTeamId(Long id) throws ResourceNotFoundException;
	public Team saveTeam(Long engineId, Team team) throws ResourceNotFoundException;
	public void deleteTheTeam(Long id) throws ResourceNotFoundException;
	public Team updateTheTeam(Long engineId, Long id, Team teamRequest) throws ResourceNotFoundException;
}
