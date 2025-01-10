package com.ceu.ej12;

import java.util.ArrayList;
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
		// 1. Obtener la lista de todos los autores.
		List<Autor> listaAutores = service.getAutores();
		
		System.out.println(listaAutores);
		
		// 3. Insertar un nuevo autor.
		Autor a1 = new Autor(1, "Angel");		
		
		//Autor autor = 
		service.addAutor(a1);
		//System.out.println(autor);
	}
}
