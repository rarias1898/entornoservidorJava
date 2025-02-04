package com.ceu.ej8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej8.model.Usuario;
import com.ceu.ej8.service.UsuarioService;

@SpringBootApplication
public class Ej8Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej8Application.class, args);
	}
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario1 = new Usuario("Angel", "email1@email.com", null);
		Usuario usuario2 = new Usuario("Ana", "email2@email.com", null);
		
		usuarioService.addUsuario(usuario1);
		usuarioService.addUsuario(usuario2);
	}

}
