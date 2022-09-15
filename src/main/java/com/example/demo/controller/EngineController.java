package com.example.demo.controller;

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
import com.example.demo.service.EngineServiceInterface;

@RestController
@RequestMapping("/engine/")
public class EngineController {

	@Autowired
	private EngineServiceInterface engineServiceInterface;

	@GetMapping("allEngines")
	public List<Engine> getAll() {
		return engineServiceInterface.getAllEngines();
	}
	
	@GetMapping
	@RequestMapping("findEngine/{id}")
	public ResponseEntity<Engine> get(@PathVariable Long id) throws ResourceNotFoundException {
		return engineServiceInterface.getEngineId(id);
	}

	@RequestMapping(value = "postEngine", method = RequestMethod.POST)
	public Engine create(@RequestBody Engine engine) {
		return engineServiceInterface.saveEngine(engine);
	}

	@RequestMapping(value = "deleteEngine/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) throws ResourceNotFoundException {
		engineServiceInterface.deleteTheEngine(id);
	}	

	@RequestMapping(value = "updateEngine/{id}", method = RequestMethod.PUT)
	public Engine updateEngine(@RequestBody Engine engine, @PathVariable Long id) throws ResourceNotFoundException {
		return engineServiceInterface.updateTheEngine(engine, id);
	}

}