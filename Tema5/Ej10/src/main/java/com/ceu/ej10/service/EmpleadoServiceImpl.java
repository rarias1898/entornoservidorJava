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
		
		if (miEmpleado != null) {
			miEmpleado.setNombre(updatedEmpleado.getNombre());
			miEmpleado.setEmail(updatedEmpleado.getEmail());
			miEmpleado.setPuesto(updatedEmpleado.getPuesto());
			miEmpleado.getOficina().setTelefono(updatedEmpleado.getOficina().getTelefono());
			miEmpleado.getOficina().setUbicacion(updatedEmpleado.getOficina().getUbicacion());
		}
		
		repository.updateEmpleado(miEmpleado);
	}

	@Override
	@Transactional
	public void deleteEmpleado(int id) {
		Empleado empleado = getEmpleadoById(id);
		
		repository.deleteEmpleado(empleado);
	}

	@Override
	public List<Empleado> getEmpleadoByPuesto(String puesto) {
		return repository.getEmpleadoByPuesto(puesto);
	}

	@Override
	public List<Empleado> getEmpleadoNoOffice() {
		List<Empleado> listaEmpleados = getEmpleados().stream()
				.filter(x -> x.getOficina() == null).toList();
		
		return listaEmpleados;
	}
}
