package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;
import com.example.demo.repository.EngineRepository;

@Service
public class EngineServiceImpli implements EngineServiceInterface {

	@Autowired
	private EngineRepository engineRepository;
	
	public List<Engine> getAllEngines (){
		return engineRepository.findAll();
	}
	
	public ResponseEntity<Engine> getEngineId (Long id) throws ResourceNotFoundException {
		Engine engine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + id));
		return ResponseEntity.ok().body(engine);
	}

	public Engine saveEngine(Engine engine) {
		return engineRepository.save(engine);
	}
	
	public void deleteTheEngine(Long id) throws ResourceNotFoundException {
		 Engine engine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + id));
		  engineRepository.delete(engine);
	}
	
	public Engine updateTheEngine(Engine engine, Long id) throws ResourceNotFoundException {
		Engine existingEngine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id : " + id));
		existingEngine.setName(engine.getName());
		existingEngine.setHqLocation(engine.getHqLocation());
		return engineRepository.save(existingEngine);
	}
}
