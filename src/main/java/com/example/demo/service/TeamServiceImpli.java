package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;
import com.example.demo.model.Team;
import com.example.demo.repository.EngineRepository;
import com.example.demo.repository.TeamRepository;

@Service
public class TeamServiceImpli implements TeamServiceInterface{

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private EngineRepository engineRepository;

	public Set<Team> getTeamByEngineID(Long engineId) {
		Optional<Engine> engine = engineRepository.findById(engineId);
		if(engine.isPresent()) {
			return engine.get().getTeams();
		}
		return null;
	}

	public List<Team> getAllTeams() {
		return teamRepository.findAll();
	}

	public ResponseEntity<Team> getTeamId(Long id) throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id : " + id));
		return ResponseEntity.ok().body(team);
	}

	public Team saveTeam(Long engineId, Team team) throws ResourceNotFoundException {
		return engineRepository.findById(engineId).map(engine -> {
			team.setEngine(engine);
			return teamRepository.save(team);
		}).orElseThrow(() -> new ResourceNotFoundException("Engine Id " + engineId + " not found"));
	}

	public void deleteTheTeam(Long id) throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for id : " + id));
		teamRepository.delete(team);
	}

	public Team updateTheTeam(Long engineId, Long id, Team teamRequest) throws ResourceNotFoundException {
		if (!engineRepository.existsById(engineId)) {
			throw new ResourceNotFoundException("Engine Id " + engineId + " not found");
		}

		return teamRepository.findById(id).map(team -> {
			team.setName(teamRequest.getName());
			team.setTrophies(teamRequest.getTrophies());
			return teamRepository.save(team);
		}).orElseThrow(() -> new ResourceNotFoundException("Team Id " + id + "not found"));
	}

}
