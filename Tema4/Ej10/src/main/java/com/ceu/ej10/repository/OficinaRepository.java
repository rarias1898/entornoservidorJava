package com.ceu.ej10.repository;

import java.util.List;

import com.ceu.ej10.model.Oficina;

public interface OficinaRepository {

	void addOficina(Oficina oficina);

	List<Oficina> getOficinas();

	Oficina getOficinaById(int id);

	void deleteOficina(Oficina oficina);

	long countEmpleadosOficina(int id);

	List<Oficina> getOficinaConMasDeNEmpleados(int numEmpleados);

}
