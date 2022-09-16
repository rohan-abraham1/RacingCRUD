package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.EngineDtoGet;
import com.example.demo.DTO.EngineDtoPost;
import com.example.demo.DTO.EngineDtoUpdate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;

public interface EngineServiceInterface {
	public List<Engine> getAllEngines ();
	public EngineDtoGet getEngineId (Long id) throws ResourceNotFoundException;
	public void deleteTheEngine(Long id) throws ResourceNotFoundException;
	public Engine updateTheEngine(EngineDtoUpdate engineDto, Long id) throws ResourceNotFoundException;
	public Engine saveEngine(EngineDtoPost engineDto);
}
