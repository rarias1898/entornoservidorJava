package com.ceu.ej10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej10.model.Empleado;
import com.ceu.ej10.service.EmpleadoService;


@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService service;
	
	// 1 - Crear un empleado con o sin oficina asociada.
	@PostMapping()
	public ResponseEntity<Void> addEmpleado(@RequestBody Empleado newEmpleado) {
		service.addEmpleado(newEmpleado);
		
		return ResponseEntity.noContent().build();
	} 
	
	// 2 - Consultar todos los empleados.
	@GetMapping()
	public ResponseEntity<List<Empleado>> getEmpleados() {
		List<Empleado> listaEmpleados = service.getEmpleados();
		
		if (listaEmpleados.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaEmpleados);
		}
	}
	
	// 3 - Consultar un empleado por su id.
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
		Empleado empleado = service.getEmpleadoById(id);
		
		if (empleado != null) {
			return ResponseEntity.ok(empleado);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 4 - Actualizar la información de un empleado, incluyendo la oficina asociada.
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateEmpleado(@RequestBody Empleado updatedEmpleado, @PathVariable int id) {
		service.updateEmpleado(updatedEmpleado, id);
		
		return ResponseEntity.noContent().build();
	}
	
	// 5 - Eliminar un empleado por su id.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
		service.deleteEmpleado(id);
		
		return ResponseEntity.noContent().build();
	}
	
	// 6 - Devolver todos los empleados que tengan un puesto especifico.
	@GetMapping("/puesto/{puesto}")
	public ResponseEntity<List<Empleado>> getEmpleadoByPuesto(@PathVariable String puesto) {
		List<Empleado> listaEmpleados = service.getEmpleadoByPuesto(puesto);
		
		if (listaEmpleados.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaEmpleados);
		}
	}
	
	
	// 7 - Devolver todos los empleados que no tengan oficina.
	@GetMapping("/no-office")
	public ResponseEntity<List<Empleado>> getEmpleadoNoOffice() {
		List<Empleado> listaEmpleados = service.getEmpleadoNoOffice();
		
		if (listaEmpleados.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaEmpleados);
		}
	}
	
}
