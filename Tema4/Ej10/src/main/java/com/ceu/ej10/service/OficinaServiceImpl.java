package com.ceu.ej10.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej10.model.Oficina;
import com.ceu.ej10.repository.OficinaRepository;

import jakarta.transaction.Transactional;

@Service
public class OficinaServiceImpl implements OficinaService {

	@Autowired
	private OficinaRepository repository;

	@Override
	@Transactional
	public void addOficina(Oficina oficina) {
		repository.addOficina(oficina);
	}

	@Override
	public List<Oficina> getOficinas() {
		return repository.getOficinas();
	}

	@Override
	public Oficina getOficinaById(int id) {
		return repository.getOficinaById(id);
	}

	@Override
	@Transactional
	public void deleteOficina(int id) {
		Oficina oficina = getOficinaById(id);
		
		repository.deleteOficina(oficina);
	}

	@Override
	public long countEmpleadosOficina(int id) {
		return repository.countEmpleadosOficina(id);
	}

	@Override
	public Map<Integer, Long> getMapNumeroEmpleados(int id) {
		long conteo = countEmpleadosOficina(id);
		
		Map<Integer, Long> mapaEmpleados = new HashMap<>();
		mapaEmpleados.put(id, conteo);
		
		return mapaEmpleados;
	}

	@Override
	public List<Oficina> getOficinaConMasDeNEmpleados(int numEmpleados) {
		return repository.getOficinaConMasDeNEmpleados(numEmpleados);
	}
}
