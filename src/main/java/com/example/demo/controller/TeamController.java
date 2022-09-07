package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;
import com.example.demo.model.Team;
import com.example.demo.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@GetMapping("/engine/{engine_id}/team/allTeamsById")
	public List<Team> getAll(@PathVariable Long engine_id) {
		List<Team> teams = new ArrayList<>();
		teamRepository.findByEngineId(engine_id).forEach(teams::add);
		return teams;
	}

	@GetMapping("allTeams")
	public List<Team> getAll() {
		return teamRepository.findAll();
	}

	@GetMapping
	@RequestMapping("findTeam/{id}")
	public ResponseEntity<Team> get(@PathVariable Long id) 
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
		          .orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + id));
		return ResponseEntity.ok().body(team);	}

	@RequestMapping(value = "/engine/{engine_id}/team/postTeam", method = RequestMethod.POST)
	public Team create(@RequestBody Team team, @PathVariable Long engine_id) {
		team.setEngine(new Engine(engine_id, "", ""));
		return teamRepository.save(team);
	}

	@RequestMapping(value = "deleteTeam/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) 
			throws ResourceNotFoundException {
		Team team = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + id));
		teamRepository.delete(team);
	}

	@RequestMapping(value = "/engine/{engine_id}/team/updateTeam/{id}", method = RequestMethod.PUT)
	public Team update(@RequestBody Team team, @PathVariable Long engine_id, @PathVariable Long id) 
			throws ResourceNotFoundException {
		Team existingTeam = teamRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Team not found for this id :: " + id));
		existingTeam.setName(team.getName());
		existingTeam.setTrophies(team.getTrophies());
		team.setEngine(new Engine(engine_id, "", ""));
		return teamRepository.save(existingTeam);
	}
}
