package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Engine;

public interface EngineServiceInterface {
	public List<Engine> getAllEngines ();
	public ResponseEntity<Engine> getEngineId (Long id) throws ResourceNotFoundException;
	public Engine saveEngine(Engine engine);
	public void deleteTheEngine(Long id) throws ResourceNotFoundException;
	public Engine updateTheEngine(Engine engine, Long id) throws ResourceNotFoundException;
}
