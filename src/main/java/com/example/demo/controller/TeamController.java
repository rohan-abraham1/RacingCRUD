package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.TeamDtoGet;
import com.example.demo.DTO.TeamDtoPost;
import com.example.demo.DTO.TeamDtoUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Team;
import com.example.demo.service.TeamServiceInterface;

@RestController
public class TeamController {

	@Autowired
	private TeamServiceInterface teamServiceInterface;

	@GetMapping("/engine/{engineId}/team/allTeamsById")
	public List<Team> getAll(@PathVariable Long engineId) throws ResourceNotFoundException {
		return teamServiceInterface.getTeamByEngineID(engineId);
	}

	@GetMapping("allTeams")
	public List<Team> getAll() {
		return teamServiceInterface.getAllTeams();
	}

	@GetMapping
	@RequestMapping("findTeam/{id}")
	public TeamDtoGet get(@PathVariable Long id) throws ResourceNotFoundException {
		return teamServiceInterface.getTeamId(id);
	}

	@RequestMapping(value = "/engine/{engineId}/team/postTeam", method = RequestMethod.POST)
	public Team createTeam(@PathVariable Long engineId, @RequestBody TeamDtoPost teamDto) throws ResourceNotFoundException {
		return teamServiceInterface.saveTeam(engineId, teamDto);
	}

	@RequestMapping(value = "/team/deleteTeam/{id}", method = RequestMethod.DELETE)
	public void deleteTeam(@PathVariable Long id) throws ResourceNotFoundException {
		teamServiceInterface.deleteTheTeam(id);
	}

	@RequestMapping(value = "/team/updateTeam/{id}", method = RequestMethod.PUT)
	public Team updateTeam(@PathVariable(value = "id") Long id,
			@RequestBody TeamDtoUpdate TeamDto) throws ResourceNotFoundException {
		return teamServiceInterface.updateTheTeam(id, TeamDto);
	}
}