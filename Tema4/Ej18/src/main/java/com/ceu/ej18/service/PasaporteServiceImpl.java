package com.ceu.ej18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.model.Persona;
import com.ceu.ej18.repository.PasaporteRepository;

import jakarta.transaction.Transactional;

@Service
public class PasaporteServiceImpl implements PasaporteService {

	@Autowired
	private PasaporteRepository repository;

	@Override
	@Transactional
	public void addPasaporte(Pasaporte pasa1) {
		repository.save(pasa1);
		
	}
	
	public Persona getPersonaByid(Integer id) {
		return repository.getPersonaByid(id);
	}
	
	public Pasaporte getPasaporteById(Integer id) {
		return repository.getPasaporteById(id);
	}

	@Override
	@Transactional
	public void addPasaporteToPersona(Integer id, Integer id2) {
		Pasaporte pasaporte = getPasaporteById(id);
		Persona persona = getPersonaByid(id2);
		
		if (pasaporte != null && persona != null) {
			persona.setPasaporte(pasaporte);
			repository.save(pasaporte);
		}
	}
}
