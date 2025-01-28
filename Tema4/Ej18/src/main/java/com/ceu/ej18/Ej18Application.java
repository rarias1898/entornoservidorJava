package com.ceu.ej18;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej18.model.Pasaporte;
import com.ceu.ej18.model.Persona;
import com.ceu.ej18.model.Proyecto;
import com.ceu.ej18.service.PasaporteService;
import com.ceu.ej18.service.PersonaService;
import com.ceu.ej18.service.ProyectoService;

@SpringBootApplication
public class Ej18Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej18Application.class, args);
	}
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private PasaporteService pasaporteService;
	
	@Autowired
	private ProyectoService proyectoService;

	@Override
	public void run(String... args) throws Exception {
		
		Persona p1 = new Persona("Juan Perez", null);
		Persona p2 = new Persona("Ana Lopez", null);
		
		Pasaporte pasa1 = new Pasaporte(53771318, null);
		Pasaporte pasa2 = new Pasaporte(81533434, null);
		
		Proyecto proy1 = new Proyecto("Proyecto Alpha");
		Proyecto proy2 = new Proyecto("Proyecto Beta");
		
		// Añadir personas
		personaService.addPersona(p1);
		personaService.addPersona(p2);
		
		// Añadir pasaporte
		pasaporteService.addPasaporte(pasa1);
		pasaporteService.addPasaporte(pasa2);
		
		// Añadir proyecto
		proyectoService.addProyecto(proy1);
		proyectoService.addProyecto(proy2);
		
		// Añadir pasaporte a persona
		pasaporteService.addPasaporteToPersona(pasa1.getId(), p1.getId());
		pasaporteService.addPasaporteToPersona(pasa2.getId(), p2.getId());
		
		// Asignar proyecto a persona
		proyectoService.addProyectoToPersona(proy1.getId(), p1.getId());
		proyectoService.addProyectoToPersona(proy2.getId(), p1.getId());
		proyectoService.addProyectoToPersona(proy1.getId(), p2.getId());
		
		// Obtener todas el nombre de todas las personas con los nombres de sus proyectos.
		List<Persona> listaPersonas = personaService.getPersonas();
		for (Persona persona : listaPersonas) {
			System.out.println(persona.getNombre());
			for (Proyecto proyecto : persona.getProyectos()) {
				System.out.println(proyecto);
			}
		}
	}

}
