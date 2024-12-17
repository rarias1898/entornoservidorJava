package com.ceu.ej10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej10.model.Oficina;
import com.ceu.ej10.service.OficinaService;

@RestController
@RequestMapping("/api/oficina")
public class OficinaController {
	
	@Autowired
	private OficinaService service;
	
	// 1 - Crear una oficina.
	@PostMapping()
	public ResponseEntity<Void> addOficina(@RequestBody Oficina oficina) {
		service.addOficina(oficina);
		
		return ResponseEntity.noContent().build();
	}
	
	// 2 - Consultar todas las oficinas.
	@GetMapping()
	public ResponseEntity<List<Oficina>> getOficinas() {
		List<Oficina> listaOficinas = service.getOficinas();
		
		if (listaOficinas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaOficinas);
		}
	}
	
	// 3 - Consultar una oficina por su id.
	@GetMapping("/{id}")
	public ResponseEntity<Oficina> getOficinaById(@PathVariable int id) {
		Oficina oficina = service.getOficinaById(id);
		
		if (oficina == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(oficina);
		}
	}
	
	// 4 - Eliminar una oficina por su id.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOficina(@PathVariable int id) {
		service.deleteOficina(id);
		
		return ResponseEntity.noContent().build();
	}
}
