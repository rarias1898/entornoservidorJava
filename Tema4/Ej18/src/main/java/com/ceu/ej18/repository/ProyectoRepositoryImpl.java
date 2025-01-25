package com.ceu.ej18.repository;

import org.springframework.stereotype.Repository;

import com.ceu.ej18.model.Persona;
import com.ceu.ej18.model.Proyecto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Proyecto proy1) {
		if (proy1.getId() == null) {
			entityManager.persist(proy1);
		}else {
			entityManager.merge(proy1);
		}
	}

	@Override
	public Persona getPersonaById(Integer id) {
		Persona persona = entityManager.find(Persona.class, id);
		return persona;
	}

	@Override
	public Proyecto getProyectoById(Integer id) {
		Proyecto proyecto = entityManager.find(Proyecto.class, id);
		return proyecto;
	}

}
