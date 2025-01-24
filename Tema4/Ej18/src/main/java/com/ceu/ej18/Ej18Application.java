package com.ceu.ej18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.model.Persona;
import com.ceu.ej18.service.PasaporteService;
import com.ceu.ej18.service.PersonaService;

@SpringBootApplication
public class Ej18Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej18Application.class, args);
	}
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PasaporteService pasaporteService;

	@Override
	public void run(String... args) throws Exception {
		
		Persona p1 = new Persona("Juan Perez", null);
		Persona p2 = new Persona("Ana Lopez", null);
		
		Pasaporte pasa1 = new Pasaporte(53771318, null);
		
		// Añadir personas
		personaService.addPersona(p1);
		personaService.addPersona(p2);
		
		// Añadir pasaporte
		pasaporteService.addPasaporte(pasa1);
	}

}
