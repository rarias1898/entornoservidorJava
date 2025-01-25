package com.ceu.ej18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej18.model.Persona;
import com.ceu.ej18.model.Proyecto;
import com.ceu.ej18.repository.ProyectoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	private ProyectoRepository repository;
	
	@Override
	@Transactional
	public void addProyecto(Proyecto proy1) {
		repository.save(proy1);
	}
	
	public Persona getPersonaById(Integer id) {
		return repository.getPersonaById(id);
	}
	
	public Proyecto getProyectoById(Integer id) {
		return repository.getProyectoById(id);
	}

	@Override
	@Transactional
	public void addProyectoToPersona(Integer id, Integer id2) {
		Proyecto proyecto = getProyectoById(id);
		Persona persona = getPersonaById(id2);
		
		if (proyecto != null && persona != null) {
			proyecto.getPersonas().add(persona);
			repository.save(proyecto);
		}
	}

}
