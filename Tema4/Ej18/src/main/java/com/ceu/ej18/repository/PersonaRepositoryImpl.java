package com.ceu.ej18.repository;

import java.util.List;

import org.hibernate.query.Query;
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

	@Override
	public List<Persona> findAll() {
		Query<Persona> query = (Query<Persona>) entityManager.createQuery("select p from Persona p", Persona.class);
		List<Persona> listaPersonas = query.getResultList();
		return listaPersonas;
	}

}
