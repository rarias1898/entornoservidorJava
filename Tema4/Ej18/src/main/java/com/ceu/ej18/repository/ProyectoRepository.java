package com.ceu.ej18.repository;

import com.ceu.ej18.model.Persona;
import com.ceu.ej18.model.Proyecto;

public interface ProyectoRepository {

	void save(Proyecto proy1);

	Persona getPersonaById(Integer id);

	Proyecto getProyectoById(Integer id);


}
