package com.ceu.ej18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.repository.PasaporteRepository;

@Service
public class PasaporteServiceImpl implements PasaporteService {

	@Autowired
	private PasaporteRepository repository;

	@Override
	public void addPasaporte(Pasaporte pasa1) {
		repository.save(pasa1);
		
	}
}
