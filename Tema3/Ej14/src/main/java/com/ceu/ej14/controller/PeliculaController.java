package com.ceu.ej14.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej14.models.Actor;
import com.ceu.ej14.models.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
	
	private List<Pelicula> peliculas = new ArrayList<>(); 
	
	public PeliculaController() {
		Pelicula p1 = new Pelicula(1, "pelicula1", "director1", LocalDate.of(1996, 03, 15), 95, List.of(new Actor(1, "actor1", "espanola"), new Actor(1, "actor2", "francesa")));
		Pelicula p2 = new Pelicula(2, "pelicula2", "director2", LocalDate.of(2023, 06, 15), 75, List.of(new Actor(2, "actor2", "francesa")));
		Pelicula p3 = new Pelicula(3, "pelicula3", "director1", LocalDate.of(2022, 01, 25), 120, List.of(new Actor(3, "actor2", "espanola")));
		
		peliculas.add(p1);
		peliculas.add(p2);
		peliculas.add(p3);
	}
	
	@GetMapping
	public ResponseEntity<List<Pelicula>> getPeliculas() {
		return ResponseEntity.ok(peliculas);
	}
	
	@GetMapping("/{titulo}")
	public ResponseEntity<Pelicula> getPelicula(@PathVariable String titulo) {
		for (Pelicula pelicula : peliculas ) {
			if(pelicula.getTitulo().equalsIgnoreCase(titulo)) {
				return ResponseEntity.ok(pelicula);
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/new")
	public ResponseEntity<Void> addPelicula(@RequestBody Pelicula newPelicula) {
		peliculas.add(newPelicula);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/total-edit")
	public ResponseEntity<Void> totalEdit(@RequestBody Pelicula editedPelicula) {
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getId() == editedPelicula.getId()) {
				pelicula.setTitulo(editedPelicula.getTitulo());
				pelicula.setDirector(editedPelicula.getDirector());
				pelicula.setFlanzamiento(editedPelicula.getFlanzamiento());
				pelicula.setDuracion(editedPelicula.getDuracion());
				pelicula.setActor(editedPelicula.getActor());
				
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@PatchMapping("/partial-edit")
	public ResponseEntity<Void> partialEdit(@RequestBody Pelicula editedPelicula) {
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getId() == editedPelicula.getId()) {
				if (editedPelicula.getTitulo() != null) {
					pelicula.setTitulo(editedPelicula.getTitulo());
				}
				if (editedPelicula.getDirector() != null) {
					pelicula.setDirector(editedPelicula.getDirector());
				}
				if (editedPelicula.getFlanzamiento() != null) {
					pelicula.setFlanzamiento(editedPelicula.getFlanzamiento());
				}
				if (editedPelicula.getDuracion() != 0) {
					pelicula.setDuracion(editedPelicula.getDuracion());
				}
				if (editedPelicula.getActor() != null) {
					pelicula.setActor(editedPelicula.getActor());
				}
				
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delPelicula(@PathVariable int id) {
		for (Pelicula pelicula : peliculas) {
			Iterator<Pelicula> iterador = peliculas.iterator();
			while (iterador.hasNext()) {
				Pelicula pel = iterador.next();
				if (pel.getId() == id) {
					iterador.remove();
					return ResponseEntity.noContent().build();
				}
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/por-director/{director}")
	public ResponseEntity<List<Pelicula>> getPeliculasPorDirector(@PathVariable String director) {
		
		List<Pelicula> porDirector = new ArrayList<>();
		
		for (Pelicula pelicula : peliculas) {
			if (pelicula.getDirector().equalsIgnoreCase(director)) {
				porDirector.add(pelicula);
			}
		}
		return ResponseEntity.ok(porDirector);
	}
	
	@GetMapping("/utimos-cinco")
	public ResponseEntity<List<Pelicula>> getPelucilasCinco() {
		
		List<Pelicula> porAnos = new ArrayList<>();
		LocalDate fechaHoy = LocalDate.now();
		
		for (Pelicula pelicula : peliculas) {
			Period p = pelicula.getFlanzamiento().until(fechaHoy); 
			if (p.getYears() < 5) {
				porAnos.add(pelicula);
			}
		}
		return ResponseEntity.ok(porAnos);
	}
	
	@GetMapping("/max-duration")
	public ResponseEntity<Pelicula> getMaxDuration() {

		Pelicula peliMax = null;
		int maxDuration = 0;
		
		for (Pelicula pelicula : peliculas) {
			if(pelicula.getDuracion() > maxDuration) {
				peliMax = pelicula;
			}
			
		}
		if (peliMax != null) {
			return ResponseEntity.ok(peliMax);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/con-mas-de/{numeroPeliculas}")
	public ResponseEntity<Map<String, Integer>> getDirectoresConMasDeX(@PathVariable int numeroPeliculas) {
		Map<String, Integer> contadorDirectores = new HashMap<>();

		for (Pelicula pelicula : peliculas) {
			String director = pelicula.getDirector();

			contadorDirectores.put(director, contadorDirectores.getOrDefault(director, 0) + 1);
		}

		Map<String, Integer> contadorDirectoresX = new HashMap<>();

		for (Map.Entry<String, Integer> entry : contadorDirectores.entrySet()) {
			if (entry.getValue() > numeroPeliculas) {
				contadorDirectoresX.put(entry.getKey(), entry.getValue());
			}
		}
		return ResponseEntity.ok(contadorDirectoresX);
	}

	@GetMapping("/actores-sin-repetir")
	public ResponseEntity<Set<Actor>> getActoresSinRepetir() {
		Set<Actor> actoresSinRepetir = new HashSet<>();

		for (Pelicula pelicula : peliculas) {
			actoresSinRepetir.addAll(pelicula.getActor());
		}
		return ResponseEntity.ok(actoresSinRepetir);
	}
	
	@GetMapping("/por-actor/{actor}")
	public ResponseEntity<List<Pelicula>> getPeliculasPorActor(@PathVariable String actor) {
		
		List<Pelicula> porActor = new ArrayList<>();
		
		for (Pelicula pelicula : peliculas) {
			for (Actor actores : pelicula.getActor()) {
				if (actores.getNombre().equalsIgnoreCase(actor)) {
					porActor.add(pelicula);
					break;
				}
			}
		}
		return ResponseEntity.ok(porActor);
	}
	
	@GetMapping("/por-nac/{nacionalidad}")
	public ResponseEntity<List<Actor>> getActoresPorNac(@PathVariable String nacionalidad) {

		List<Actor> porNac = new ArrayList<>();

		for (Pelicula pelicula : peliculas) {
			for (Actor actores : pelicula.getActor()) {
				if (actores.getNacionalidad().equalsIgnoreCase(nacionalidad)) {
					porNac.add(actores);
					break;
				}
			}
		}
		return ResponseEntity.ok(porNac);
	}
}
