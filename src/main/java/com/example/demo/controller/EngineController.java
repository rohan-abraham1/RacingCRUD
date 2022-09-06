package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Engine;
import com.example.demo.repository.EngineRepository;

@RestController
@RequestMapping("/engine/")
public class EngineController {
	
	@Autowired
	private EngineRepository engineRepository;
	
	@GetMapping("allEngines")
	public List<Engine> getAll(){
		return engineRepository.findAll();
	}

	@GetMapping
	@RequestMapping("findEngine/{id}")
	public Optional<Engine> get(@PathVariable Long id) {
		return engineRepository.findById(id);
	}
	
	@RequestMapping(value="postEngine", method = RequestMethod.POST)
	public Engine create(@RequestBody Engine engine) {
		return engineRepository.save(engine);
	}
	
	@RequestMapping(value="deleteEngine/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		engineRepository.deleteById(id);
	}
	
	@RequestMapping(value = "updateEngine/{id}", method = RequestMethod.PUT)
	public Engine update(@RequestBody Engine engine,@PathVariable Long id) {
		Engine existingEngine = engineRepository.findById(id).get();
		existingEngine.setName(engine.getName());
		existingEngine.setHqLocation(engine.getHqLocation());
		return engineRepository.save(existingEngine);
	}
}
