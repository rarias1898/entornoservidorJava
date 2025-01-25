package com.ceu.ej18.repository;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.model.Persona;

public interface PasaporteRepository {

	void save(Pasaporte pasa1);

	Persona getPersonaByid(Integer id);

	Pasaporte getPasaporteById(Integer id);

}
