package com.ceu.ej18.repository;

import java.util.List;

import com.ceu.ej18.model.Persona;

public interface PersonaRepository {

	void save(Persona p1);

	List<Persona> findAll();

}
