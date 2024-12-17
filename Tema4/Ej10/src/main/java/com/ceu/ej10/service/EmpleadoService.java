package com.ceu.ej10.service;

import java.util.List;

import com.ceu.ej10.model.Empleado;

public interface EmpleadoService {

	void addEmpleado(Empleado newEmpleado);

	List<Empleado> getEmpleados();

	Empleado getEmpleadoById(int id);

	void updateEmpleado(Empleado updatedEmpleado, int id);

}
