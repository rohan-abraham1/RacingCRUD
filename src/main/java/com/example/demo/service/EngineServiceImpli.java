package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.EngineDtoGet;
import com.example.demo.DTO.EngineDtoGetAll;
import com.example.demo.DTO.EngineDtoPost;
import com.example.demo.DTO.EngineDtoUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;
import com.example.demo.repository.EngineRepository;

@Service
public class EngineServiceImpli implements EngineServiceInterface {

	@Autowired
	private EngineRepository engineRepository;
	
	public List<Engine> getAllEngines (){
		EngineDtoGetAll engineDto = new EngineDtoGetAll();
		engineDto.setEngineList(engineRepository.findAll());
		return (engineDto.getEngineList());
	}
	
	public EngineDtoGet getEngineId (Long id) throws ResourceNotFoundException {
		Engine engine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + id));
		EngineDtoGet engineDto = new EngineDtoGet();
		engineDto.setId(engine.getId());
		engineDto.setName(engine.getName());
		engineDto.setHqLocation(engine.getHqLocation());
		return engineDto;
	}

	public Engine saveEngine(EngineDtoPost engineDto) {
		Engine engine = new Engine();
		engine.setName(engineDto.getName());
		engine.setHqLocation(engineDto.getHqLocation());
		return engineRepository.save(engine);
	}
	
	public void deleteTheEngine(Long id) throws ResourceNotFoundException {
		 Engine engine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + id));
		  engineRepository.delete(engine);
	}
	
	public Engine updateTheEngine(EngineDtoUpdate engineDto, Long id) throws ResourceNotFoundException {
		Engine existingEngine = engineRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Engine not found for this id : " + id));
		existingEngine.setName(engineDto.getName());
		existingEngine.setHqLocation(engineDto.getHqLocation());
		return engineRepository.save(existingEngine);
	}
}
