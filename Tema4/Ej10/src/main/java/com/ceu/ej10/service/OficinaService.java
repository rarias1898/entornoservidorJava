package com.ceu.ej10.service;

import java.util.List;

import com.ceu.ej10.model.Oficina;

public interface OficinaService {

	void addOficina(Oficina oficina);

	List<Oficina> getOficinas();

	Oficina getOficinaById(int id);

	void deleteOficina(int id);

}
