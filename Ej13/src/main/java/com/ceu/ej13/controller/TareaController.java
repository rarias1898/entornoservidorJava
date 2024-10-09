package com.ceu.ej13.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej13.model.Tarea;

@RestController
@RequestMapping("/tareas")
public class TareaController {

	private List<Tarea> tareas = new ArrayList<>();
	
	public TareaController() {
		
		Tarea t1 = new Tarea(1, "tarea1", "descripcion1", "Lunes", "Pendiente");
		Tarea t2 = new Tarea(2, "tarea2", "descripcion2", "Martes", "Pendiente");
		Tarea t3 = new Tarea(3, "tarea3", "descripcion3", "Lunes", "Completa");
		
		tareas.add(t1);
		tareas.add(t2);
		tareas.add(t3);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tarea>> getTareas() {
		return ResponseEntity.ok(tareas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarea> getIdTarea(@PathVariable int id) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				return ResponseEntity.ok(tarea);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> addTarea(@RequestBody Tarea newTarea) {
		tareas.add(newTarea);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> editTarea(@PathVariable int id, @RequestBody Tarea editedTarea) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				tarea.setTitulo(editedTarea.getTitulo());
				tarea.setDescripcion(editedTarea.getDescripcion());
				tarea.setFecha(editedTarea.getFecha());
				tarea.setEstado(editedTarea.getEstado());
				
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> editSTarea(@PathVariable int id, @RequestBody Tarea editedTarea) {
		for (Tarea tarea : tareas) {
			if (tarea.getId() == id) {
				if (editedTarea.getTitulo() != null) {
					tarea.setTitulo(editedTarea.getTitulo());
				}
				if (editedTarea.getDescripcion() != null) {
					tarea.setFecha(editedTarea.getFecha());
				}
				if (editedTarea.getEstado() != null) {
					tarea.setEstado(editedTarea.getEstado());
				}
				
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/estado/{estado}")
	public ResponseEntity<List<Tarea>> getTareaEstado(@PathVariable String estado) {
		
		List<Tarea> estados = new ArrayList<>();
		
		for (Tarea tarea : tareas) {
			if (tarea.getEstado().equalsIgnoreCase(estado)) {
				estados.add(tarea);
			}
		}
		return ResponseEntity.ok(estados);
	}
	
	
	
	
	
	
	
	
	
	
}
