package com.ceu.ej1.controller;

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

import com.ceu.ej1.model.Cliente;
import com.ceu.ej1.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteServiceImpl service;

	@GetMapping
	public ResponseEntity<List<Cliente>> getClientes() {
		List<Cliente> clientes = service.getClientes();
		return ResponseEntity.ok(clientes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getCliente(@PathVariable int id) {
		Cliente cliente = service.getCliente(id);
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Void> addCliente(@RequestBody Cliente newCliente) {
		service.addCliente(newCliente);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
		service.deleteCliente(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> actualizarCliente(@PathVariable int id, @RequestBody Cliente editClient) {
		service.actualizarCliente(id, editClient);
		return ResponseEntity.noContent().build();
	}
	
	
}
