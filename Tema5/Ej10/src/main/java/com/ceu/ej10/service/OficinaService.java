package com.ceu.ej10.service;

import java.util.List;
import java.util.Map;

import com.ceu.ej10.model.Oficina;

public interface OficinaService {

	void addOficina(Oficina oficina);

	List<Oficina> getOficinas();

	Oficina getOficinaById(int id);

	void deleteOficina(int id);

	long countEmpleadosOficina(int id);

	Map<Integer, Long> getMapNumeroEmpleados(int id);

	List<Oficina> getOficinaConMasDeNEmpleados(int numEmpleados);

}
