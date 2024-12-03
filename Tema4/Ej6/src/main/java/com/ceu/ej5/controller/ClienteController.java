package com.ceu.ej5.controller;

import java.util.List;

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

import com.ceu.ej5.model.Cliente;
import com.ceu.ej5.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	// 1 - Obtener la lista de clientes.
	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> listaClientes = service.getClientes();
		
		if (listaClientes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(listaClientes);
		}
	}
	
	// 2 - Obtener los datos de un cliente dado su id
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable int id) {
		Cliente client = service.getCliente(id);
		
		if (client == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(client);
		}
	}
	
	// 3 - Insertar un nuevo cliente.
	@PostMapping
	public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
		Cliente client = service.addCliente(cliente);
		
		return ResponseEntity.ok(client);
	}
	
	// 4 - Actualizar los datos de un cliente.
	@PutMapping
	public ResponseEntity<Void> updateCliente(@RequestBody Cliente updatedCliente) {
		service.updateCliente(updatedCliente);
		
		return ResponseEntity.noContent().build();
	}
	
	// 5 - Eliminar un cliente por su id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
		service.deleteCliente(id);
		
		return ResponseEntity.noContent().build();
	}
	
	// 6 - Modificar la dirección de un cliente. Recibe el id del cliente y la nueva dirección.
	@PatchMapping("/{id}")
	public ResponseEntity<Void> updateDireccion(@PathVariable int id, @RequestBody Cliente updatedCliente) {
		service.updateDireccion(id, updatedCliente);
		
		return ResponseEntity.noContent().build();
	}
}
