package com.ceu.ej18.repository;

import org.springframework.stereotype.Repository;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PasaporteRepositoryImpl implements PasaporteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Pasaporte pasa1) {
		if (pasa1.getId() == null) {
			entityManager.persist(pasa1);
		}else {
			entityManager.merge(pasa1);
		}
	}

	@Override
	public Persona getPersonaByid(Integer id) {
		Persona persona = entityManager.find(Persona.class, id);
		return persona;
	}

	@Override
	public Pasaporte getPasaporteById(Integer id) {
		Pasaporte pasaporte = entityManager.find(Pasaporte.class, id);
		return pasaporte;
	}
	
	
}
