package com.ceu.ej10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej10.model.Empleado;
import com.ceu.ej10.repository.EmpleadoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository repository;

	@Override
	@Transactional
	public void addEmpleado(Empleado newEmpleado) {
		repository.addEmpleado(newEmpleado);
	}

	@Override
	public List<Empleado> getEmpleados() {
		return repository.getEmpleados();
	}

	@Override
	public Empleado getEmpleadoById(int id) {
		return repository.getEmpleadoById(id);
	}

	@Override
	@Transactional
	public void updateEmpleado(Empleado updatedEmpleado, int id) {
		Empleado miEmpleado = getEmpleadoById(id);
		
		
	}
}
