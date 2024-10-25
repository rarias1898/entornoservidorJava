package com.ceu.ej15.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.ceu.ej15.models.Album;
import com.ceu.ej15.models.Artista;
import com.ceu.ej15.models.Cancion;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

	private List<Album> albums = new ArrayList<>();
	
	public TiendaController() {
 
        List<Artista> artistas1 = new ArrayList<>();
        artistas1.add(new Artista(1, "Freddie Mercury", "Británico"));
        artistas1.add(new Artista(2, "Brian May", "Británico"));
 
        List<Artista> artistas2 = new ArrayList<>();
        artistas2.add(new Artista(3, "Kurt Cobain", "Americano"));
        artistas2.add(new Artista(4, "Dave Grohl", "Americano"));
 
        List<Cancion> canciones1 = new ArrayList<>();
        canciones1.add(new Cancion(1, "Bohemian Rhapsody", artistas1));
        canciones1.add(new Cancion(2, "Don't Stop Me Now", artistas1));
 
        List<Cancion> canciones2 = new ArrayList<>();
        canciones2.add(new Cancion(3, "Smells Like Teen Spirit", artistas2));
        canciones2.add(new Cancion(4, "Come As You Are", artistas2));
 
        albums.add(new Album(1, "A Night at the Opera", "Queen", LocalDate.of(2024, 10, 10), canciones1, artistas1));
        albums.add(new Album(2, "Nevermind", "Nirvana", LocalDate.of(2023, 12, 23), canciones2, artistas2));
    }

	@GetMapping
	public ResponseEntity<List<Album>> getAllAlbums() {
		return ResponseEntity.ok(albums);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable int id) {
		for (Album album : albums) {
			if (album.getId() == id) {
				return ResponseEntity.ok(album);
			}
		}
		
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/add")
	public ResponseEntity<Void> addAlbum(@RequestBody Album newAlbum) {
		albums.add(newAlbum);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/edit")
	public ResponseEntity<Void> editAlbum(@RequestBody Album editedAlbum) {
		for (Album album : albums) {
			if (album.getId() == editedAlbum.getId()) {
				album.setTitulo(editedAlbum.getTitulo());
				album.setArtistaPrincipal(editedAlbum.getArtistaPrincipal());
				album.setAnioLanzamiento(editedAlbum.getAnioLanzamiento());
				album.setCancion(editedAlbum.getCancion());

				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PatchMapping("/edit")
	public ResponseEntity<Void> editPAlbum(@RequestBody Album editedAlbum) {
		for (Album album : albums) {
			if (album.getId() == editedAlbum.getId()) {
				if (editedAlbum.getTitulo() != null) {
					album.setTitulo(editedAlbum.getTitulo());
				}
				if (editedAlbum.getArtistaPrincipal() != null) {
					album.setArtistaPrincipal(editedAlbum.getArtistaPrincipal());
				}
				if (editedAlbum.getAnioLanzamiento() != null) {
					album.setAnioLanzamiento(editedAlbum.getAnioLanzamiento());
				}
				if (editedAlbum.getCancion() != null) {
					album.setCancion(editedAlbum.getCancion());
				}

				return ResponseEntity.noContent().build();
			}
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delAlbum(@PathVariable int id) {
		Iterator<Album> iterator = albums.iterator();
		while (iterator.hasNext()) {
			Album al = iterator.next();
			if (al.getId() == id) {
				iterator.remove();
				return ResponseEntity.noContent().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/by-album/{tituloAlbum}")
	public ResponseEntity<List<Cancion>> cancionesByAlbum(@PathVariable String tituloAlbum) {
		List<Cancion> canciones = new ArrayList<>();

		for (Album album : albums) {
			if (album.getTitulo().equalsIgnoreCase(tituloAlbum)) {
				canciones.addAll(album.getCancion());
				break;
			}
		}

		if (canciones.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(canciones);
	}

	@GetMapping("/by-artista/{nombreArtista}")
	public ResponseEntity<List<Cancion>> cancionesByArtista(@PathVariable String nombreArtista) {
		List<Cancion> canciones = new ArrayList<>();

		for (Album album : albums) {
			for (Artista artista : album.getArtista()) {
				if (artista.getNombre().equalsIgnoreCase(nombreArtista)) {
					canciones.addAll(album.getCancion());
					break;
				}
			}
		}

		if (canciones.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(canciones);
	}

	@GetMapping("/artista-sin-repetir")
	public ResponseEntity<Set<Artista>> artistaSinrepetir() {
		Set<Artista> artistaSinRepetir = new HashSet<>();
		
		for (Album album : albums) {
			artistaSinRepetir.addAll(album.getArtista());
		}
		
		if (artistaSinRepetir.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(artistaSinRepetir);
	}

	@GetMapping("/artista-x-canciones")
	public ResponseEntity<Map<String, Integer>> artistaXCanciones() {
		Map<String, Integer> contadorArtistas = new HashMap<>();

		for (Album album : albums) {
			for (Cancion cancion : album.getCancion()) {
				for (Artista artista : cancion.getArtista()) {
					String nombreArtista = artista.getNombre();
					contadorArtistas.put(nombreArtista, contadorArtistas.getOrDefault(nombreArtista, 0) + 1);
				}
			}
		}

		if (contadorArtistas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(contadorArtistas);
	}
}
