package com.ej2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ej2.models.Cliente;

@RestController
public class ApiController {

	private List<Cliente> clientes = new ArrayList<>();
	
	public ApiController() {
		Cliente c1 = new Cliente(1, "angel", "aaridom", "pass1");
		Cliente c2 = new Cliente(2, "pepe", "pepipo", "pass2");
		Cliente c3 = new Cliente(3, "paco", "maracar", "pass3");
		Cliente c4 = new Cliente(4, "manolo", "tamarindo", "pass4");
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
	}
	
	@GetMapping("/cliente")
	public List<Cliente> getClients() {
		return clientes;
	}
	
	@GetMapping("cliente/{username}")
	public Cliente getClient(@PathVariable String username) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getUsername().equalsIgnoreCase(username)) {
				return cliente;
			}
		}
		return null;
	}

	@PostMapping("/clientes")
	public Cliente addClient(@RequestBody Cliente newClient) {

		clientes.add(newClient);
		return newClient;
	}

	@PutMapping("/cliente/{id}")
	public Cliente updateClient(@PathVariable int id, @RequestBody Cliente updatedClient) {

		for(Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				cliente.setName(updatedClient.getName());
				cliente.setUsername(updatedClient.getUsername());
				cliente.setPassword(updatedClient.getPassword());

				return cliente;
			}
		}
		return null;
	}

	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable int id) {

		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				clientes.remove(cliente);
				return ResponseEntity.ok("Cliente eliminado");
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
	}

	@PatchMapping("/cliente/{id}")
	public Cliente updateSmallClient(@PathVariable int id, @RequestBody Cliente updateClient) {

		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				cliente.setName(updateClient.getName());

				return cliente;
			}
		}

		return null;
	}
}
