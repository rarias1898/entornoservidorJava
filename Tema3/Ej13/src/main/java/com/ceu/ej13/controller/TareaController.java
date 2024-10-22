package com.ceu.ej13.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ceu.ej13.model.Tarea;

@RestController
@RequestMapping("/tareas")
public class TareaController {

	private List<Tarea> tareas = new ArrayList<>();
	
	public TareaController() {
		
		Tarea t1 = new Tarea(1, "tarea1", "descripcion1 hola", LocalDate.of(2024, 10, 22), "Pendiente");
		Tarea t2 = new Tarea(2, "tarea2", "descripcion2", LocalDate.of(2024, 10, 15), "Pendiente");
		Tarea t3 = new Tarea(3, "tarea3", "descripcion3", LocalDate.of(2024, 10, 17), "Pendiente");
		
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

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTarea(@PathVariable int id) {
		for (Tarea tarea : tareas) {
			Iterator<Tarea> iterador = tareas.iterator();
			while (iterador.hasNext()) {
				Tarea alumno = iterador.next();
				if (alumno.getId() == id) {
					iterador.remove();
					return ResponseEntity.noContent().build();
				}
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

	@GetMapping("/proximas/{dias}")
	public ResponseEntity<List<Tarea>> getTareaVencer(@PathVariable int dias) {
		List<Tarea> vencers = new ArrayList<>();
		LocalDate fechaActual = LocalDate.now();

		for (Tarea tarea : tareas) {
			long diasRestantes = ChronoUnit.DAYS.between(fechaActual, tarea.getFecha());

			if (diasRestantes <= dias && diasRestantes >= 0) {
				vencers.add(tarea);
			}
		}
		return ResponseEntity.ok(vencers);
	}

	@GetMapping("/contar-estado")
	public ResponseEntity<Map<String, Integer>> contarTareasEstado() {
		Map<String, Integer> estados = new HashMap<>();

		for (Tarea tarea : tareas) {
			String estado = tarea.getEstado();

			estados.put(estado, estados.getOrDefault(estado, 0) + 1);
		}
		return ResponseEntity.ok(estados);
	}

	
	@GetMapping("/por-desc/{descripcion}")
	public ResponseEntity<List<Tarea>> getTareaDescr(@PathVariable String descripcion) {
		List<Tarea> filtroDesc = new ArrayList<>();
		for (Tarea tarea : tareas) {
			if (tarea.getDescripcion().contains(descripcion)) {
				filtroDesc.add(tarea);
			}
		}
		return ResponseEntity.ok(filtroDesc);
	}
	
	@PatchMapping("/marcar-completadas")
	public ResponseEntity<Void> tareasCompletadas() {
		LocalDate fechaActual = LocalDate.now();
		for (Tarea tarea : tareas) {
			if(tarea.getFecha().isAfter(fechaActual) || tarea.getFecha().isEqual(fechaActual)) {
				tarea.setEstado("Completa");
			}
		}
		return ResponseEntity.noContent().build();
	}
	
}
