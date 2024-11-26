package com.ceu.ej5.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.ceu.ej5.model.Animal;
import com.ceu.ej5.service.AnimalService;

@RestController
@RequestMapping("/api/animales")
public class AnimalController {

	@Autowired
	private AnimalService service;
	
	@PostMapping
	public ResponseEntity<Animal> addAnimal(@RequestBody Animal newAnimal) {
		Animal animal = service.addAnimal(newAnimal);
		
		return ResponseEntity.ok(animal);
	}
	
	@GetMapping
	public ResponseEntity<List<Animal>> getAnimales() {
		List<Animal> listaAnimales = service.getAnimales();
		
		if (listaAnimales != null) {
			return ResponseEntity.ok(listaAnimales);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
		Animal animal = service.getAnimalById(id);
		
		if (animal != null) {
			return ResponseEntity.ok(animal);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
		updatedAnimal.setId(id);
		service.updateAnimal(updatedAnimal);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
		service.deleteAnimal(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/especie/{especie}")
	public ResponseEntity<List<Animal>> getAnimalesByEspecie(@PathVariable String especie) {
		List<Animal> listaAnimales = service.getAnimalesByEspecie(especie);
		
		if (listaAnimales != null) {
			return ResponseEntity.ok(listaAnimales);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/edad/{edad}")
	public ResponseEntity<List<Map<String, String>>> getAnimalesByEdad(@PathVariable int edad) {
		List<Animal> listaAnimales = service.getAnimalesByEdad(edad);
		
		List<Map<String, String>> mapaRes = listaAnimales.stream()
				.map(a -> {
					Map<String, String> map = new HashMap<>();
					map.put("Nombre", a.getNombre());
					map.put("Especie", a.getEspecie());
					map.put("Habitat", a.getHabitat());
					return map;
				})
				.collect(Collectors.toList());
		
		if (mapaRes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(mapaRes);
		}
	}
	// prueba git
	@GetMapping("/recientes/{anyo}")
	public ResponseEntity<List<Map<String, Object>>> getAnimalesRecientes(@PathVariable int anyo) {
		List<Animal> listaAnimales = service.getAnimalesRecientes(anyo);
		
		List<Map<String, Object>> mapaRes = listaAnimales.stream()
				.map(a -> {
					Map<String, Object> map = new HashMap<>();
					map.put("Nombre", a.getNombre());
					map.put("Fecha", a.getFechaIngreso());
					map.put("Especie", a.getEspecie());
					return map;
				})
				.collect(Collectors.toList());
		
		if (mapaRes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(mapaRes);
		}
	}
}
