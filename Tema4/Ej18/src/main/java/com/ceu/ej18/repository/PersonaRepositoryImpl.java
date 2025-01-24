package com.ceu.ej18.repository;

import org.springframework.stereotype.Repository;

import com.ceu.ej18.model.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PersonaRepositoryImpl implements PersonaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Persona p1) {
		if (p1.getId() == null) {
			entityManager.persist(p1);
		}else {
			entityManager.merge(p1);
		}
	}

}
