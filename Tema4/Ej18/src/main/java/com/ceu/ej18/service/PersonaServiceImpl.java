package com.ceu.ej18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej18.model.Persona;
import com.ceu.ej18.repository.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository repository;

	@Override
	@Transactional
	public void addPersona(Persona p1) {
		repository.save(p1);
	}

}
