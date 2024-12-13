package com.ceu.ej8.controller;

import java.util.List;

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

import com.ceu.ej8.model.Usuario;
import com.ceu.ej8.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;

	// 1 - Obtener la lista de todos los usuarios.
	@GetMapping()
	public ResponseEntity<List<Usuario>> getUsuarios() {
		List<Usuario> listaUsuarios = service.getUsuarios();
		
		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaUsuarios);
		}
	}
	
	// 2 - Obtener los datos de un usuario dado su ID.
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
		Usuario usuario = service.getUsuarioById(id);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(usuario);
		}
	}
	
	// 3 - Insertar un nuevo usuario.
	@PostMapping()
	public ResponseEntity<Void> addUsuario(@RequestBody Usuario usuario) {
		service.addUsuario(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	// 4 - Actualizar los datos de un usuario.
	@PutMapping()
	public ResponseEntity<Void> updateUsuario(@RequestBody Usuario updatedUsuario) {
		service.updateUsuario(updatedUsuario);
		
		return ResponseEntity.noContent().build();
	}
	
	// 5 - Eliminar un usuario dado su ID.
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable int id) {
		service.deleteUsuario(id);
		
		return ResponseEntity.noContent().build();
	}
}
