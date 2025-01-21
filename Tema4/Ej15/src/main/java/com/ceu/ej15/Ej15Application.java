package com.ceu.ej15;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej15.model.Curso;
import com.ceu.ej15.model.Estudiante;
import com.ceu.ej15.service.CursoService;

@SpringBootApplication
public class Ej15Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej15Application.class, args);
	}
	
	@Autowired
	private CursoService service;

	@Override
	public void run(String... args) throws Exception {
		
		Curso c1 = new Curso("Curso1", "descripcion curso 1");
		Curso c2 = new Curso("Cliente", "Cliente web");
		Estudiante e1 = new Estudiante("Angel", "rarias1898@ceuandalucia.es");
		
		// 1. Agregar un curso
		service.addCurso(c1);
		service.addCurso(c2);
		
		// 2. Agrega un estudiante a un curso
		service.addEstudianteToCurso(c1.getId(), e1);
		
		// 3. Consultar todos los cursos
		List<Curso> listaCursos = service.getCursos();
		System.out.println("--------------------------------------------------------");
		System.out.println(listaCursos);
		
		// 4. Consultar un curso por su ID
		Curso curso = service.getCursoById(c1.getId());
		System.out.println("------------------------------------------------------");
		System.out.println(curso);
		
		// 5. Buscar los cursos cuyo nombre contenga una palabra.
		List<Curso> listaCursos2 = service.getCursoByWord("cliente");
		System.out.println("------------------------------------------------------");
		System.out.println(listaCursos2);
		
		// 6. Eliminar un estudiante de un curso
		service.deleteEstudianteFromCurso(c1.getId(), e1);
	}

}
