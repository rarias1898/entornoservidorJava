package com.ceu.ej12;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej12.model.Autor;
import com.ceu.ej12.service.AutorService;

@SpringBootApplication
public class Ej12Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej12Application.class, args);
	}
	
	@Autowired
	private AutorService service;

	@Override
	public void run(String... args) throws Exception {
		
		Autor a1 = new Autor("Angel");
		Autor a2 = new Autor("Pepe");
		Autor modifAutor = new Autor("Pacopepe");
		
		// 3. Insertar un nuevo autor.		
		service.addAutor(a1);
		service.addAutor(a2);
		
		// 1. Obtener la lista de todos los autores.
		System.out.println("Obtener la lista de usuarios");
		List<Autor> listaAutores = service.getAutores();
		
		System.out.println(listaAutores);
		
		// 2. Obtener los datos de un autor dado su ID.
		System.out.println("Obtener usuario dado su id");
		Autor autor = service.getAutorById(a1.getId());
		System.out.println(autor);
		
		// 4. Actualizar los datos de un autor
		Autor modif = service.updateAutor(a1.getId(), modifAutor);
		System.out.println(modif);
		
		// 5. Eliminar un autor dado su ID.
		System.out.println("Eliminar Autor por su ID");
		service.deleteAutor(a1.getId());
	}
}
