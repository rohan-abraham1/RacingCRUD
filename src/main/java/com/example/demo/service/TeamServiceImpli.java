package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.TeamDtoGet;
import com.example.demo.DTO.TeamDtoGetAll;
import com.example.demo.DTO.TeamDtoPost;
import com.example.demo.DTO.TeamDtoUpdate;
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
		TeamDtoGetAll teamDtoGetAll = new TeamDtoGetAll();
		teamDtoGetAll.setTeamList(teamRepository.findAll());
		return (teamDtoGetAll.getTeamList());
	}

	public TeamDtoGet getTeamId(Long id) throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id : " + id));
		TeamDtoGet teamDto = new TeamDtoGet();
		teamDto.setId(team.getId());
		teamDto.setName(team.getName());
		teamDto.setTrophies(team.getTrophies());
		return teamDto;
	}

	public Team saveTeam(Long engineId, TeamDtoPost teamDto) throws ResourceNotFoundException {
		Engine engine = engineRepository.findById(engineId)
					.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + engineId));
		Team team = new Team();
		team.setEngine(engine);
		team.setName(teamDto.getName());
		team.setTrophies(teamDto.getTrophies());
		return teamRepository.save(team);
	}

	public void deleteTheTeam(Long id) throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for id : " + id));
		teamRepository.delete(team);
	}

	public Team updateTheTeam(Long engineId, Long id, TeamDtoUpdate teamDto) throws ResourceNotFoundException {
		if (!engineRepository.existsById(engineId)) {
			throw new ResourceNotFoundException("Engine Id " + engineId + " not found");
		}
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team Id " + id + "not found"));
		team.setName(teamDto.getName());
		team.setTrophies(teamDto.getTrophies());
		return teamRepository.save(team);
	}

}
