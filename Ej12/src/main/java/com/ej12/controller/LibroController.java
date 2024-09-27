package com.ej12.controller;

import com.ej12.model.Libros;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibroController {

    private List<Libros> libros = new ArrayList<>();

    public LibroController() {
        List<String> generos1 = Arrays.asList("SC-FI", "Aventura", "Novela");
        Libros l1 = new Libros(1, "titulo1", "autor1", "editorial1", "1234", 2004, generos1);

        List<String> generos2 = Arrays.asList("Documental", "Historia");
        Libros l2 = new Libros(2, "titulo2", "autor2", "editorial2", "5678", 2005, generos2);

        List<String> generos3 = Arrays.asList("SC-FI", "Fantasía", "Terror");
        Libros l3 = new Libros(3, "titulo3", "autor3", "editorial3", "9101", 2006, generos3);

        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libros>> getLibros() {

        if (libros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(libros);
    }

    @GetMapping("/libros/{titulo}")
    public ResponseEntity<Libros> getLibroTitle(@PathVariable String titulo) {

        for (Libros libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return ResponseEntity.ok(libro);
            }
        }
        return null;
    }

    @PostMapping("/libros/add")
    public ResponseEntity<String> addLibro(@RequestBody Libros newLibro) {

        for (Libros libro : libros) {
            if (libro.getId() == newLibro.getId()) {
                return ResponseEntity.badRequest().body("El libro con esa id ya existe");
            }
            libros.add(newLibro);
            return ResponseEntity.ok("Libro creado");
        }
        return null;
    }

    @PutMapping("/libros/{id}")
    public ResponseEntity<String> editLibro(@PathVariable int id, @RequestBody Libros editedLibro) {

        for (Libros libro : libros) {
            if (libro.getId() == id) {
                libro.setTitulo(editedLibro.getTitulo());
                libro.setAutor(editedLibro.getAutor());
                libro.setEditorial(editedLibro.getEditorial());
                libro.setIsbn(editedLibro.getIsbn());
                libro.setAnoPublicacion(editedLibro.getAnoPublicacion());
                libro.setGeneros(editedLibro.getGeneros());

                return ResponseEntity.ok("Libro editado con éxito");
            }
            return ResponseEntity.badRequest().body("No se ha encontrado un libro con esa id");
        }
        return null;
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable int id) {

        for (Libros libro : libros) {
            if (libro.getId() != id) {
                return ResponseEntity.noContent().build();
            }
            libros.remove(libro);
            return ResponseEntity.ok("Libro borrado");
        }
        return null;
    }

    @GetMapping("/libros/novelas")
    public ResponseEntity<List<Libros>> getNovelas() {

        List<Libros> novelas = new ArrayList<>();
        for (Libros libro : libros) {
            if (libro.getGeneros().contains("Novela")) {
                novelas.add(libro);
                return ResponseEntity.ok(novelas);
            }
            return ResponseEntity.notFound().build();
        }
        return null;
    }

    @GetMapping("/libros/genero/{genero}")
    public ResponseEntity<List<Libros>> getLibroGenero(@PathVariable String genero) {

        List<Libros> generos = new ArrayList<>();
        for (Libros libro : libros) {
            if (libro.getGeneros().contains(genero)) {
                generos.add(libro);
            }
        }

        if (genero.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(generos);
    }
}