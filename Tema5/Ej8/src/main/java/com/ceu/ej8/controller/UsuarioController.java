package com.ceu.ej8.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.ceu.ej8.model.Perfil;
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
	
	// 6 - Actualizar el perfil de un usuario. Recibe el id del usuario y su nuevo perfil.
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updatePerfil(@PathVariable int id, @RequestBody Usuario perfil) {
		service.updatePerfil(id, perfil);
		
		return ResponseEntity.noContent().build();
	}
	
	// 7 - Obtener el perfil de un usuario dado su ID.
	@GetMapping("/perfil/{id}")
	public ResponseEntity<Perfil> getPerfil(@PathVariable int id) {
		Perfil usuario = service.getPerfil(id);
		
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// 8 - Actualizar el estado de un perfil a ‘DISPONIBLE’ dado el id del usuario.
	@PatchMapping("/estado/{id}")
	public ResponseEntity<Void> updateEstado(@PathVariable int id) {
		service.updateEstado(id);
		
		return ResponseEntity.noContent().build();
	}
	
	// 9 - Obtener la lista de usuarios cuya biografía contenga la palabra ‘edad.
	@GetMapping("/bio")
	public ResponseEntity<List<Usuario>> getUsuariosContainsEdad() {
		List<Usuario> listaUsuarios = service.getUsuariosContainsEdad();
		
		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaUsuarios);
		}
	}
	
	// 10 - Obtener el primer usuario cuyo estado sea ‘DISPONIBLE’.
	@GetMapping("/estado-disponible")
	public ResponseEntity<Optional<Usuario>> getFirstDisponible() {
		Optional<Usuario> usuario = service.getFirstDisponible();
		
		return ResponseEntity.ok(usuario);
	}
	
	// 11 - Buscar todos los usuarios cuyo estado sea ‘NO DISPONIBLE’.
	@GetMapping("/estado-no-disponible")
	public ResponseEntity<List<Usuario>> getNoDisponibles() {
		List<Usuario> listaUsuarios = service.getNoDisponibles();
		
		if (listaUsuarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaUsuarios);
		}
	}
	
	// 12 - Poned el estado de todos los usuario a ‘DISPONIBLE’.
	@PatchMapping("/estado-to-disponible")
	public ResponseEntity<Void> updateAllToDisponible() {
		service.updateAllToDisponible();
		
		return ResponseEntity.noContent().build();
	}
}
