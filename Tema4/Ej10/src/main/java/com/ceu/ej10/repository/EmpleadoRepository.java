package com.ceu.ej10.repository;

import java.util.List;

import com.ceu.ej10.model.Empleado;

public interface EmpleadoRepository {

	void addEmpleado(Empleado newEmpleado);

	List<Empleado> getEmpleados();

	Empleado getEmpleadoById(int id);

}
