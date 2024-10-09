package com.ej2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ej2.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ApiController2 {

	private List<Cliente> clientes = new ArrayList<>();
	
	public ApiController2() {
		Cliente c1 = new Cliente(1, "angel", "aaridom", "pass1");
		Cliente c2 = new Cliente(2, "pepe", "pepipo", "pass2");
		Cliente c3 = new Cliente(3, "paco", "maracar", "pass3");
		Cliente c4 = new Cliente(4, "manolo", "tamarindo", "pass4");
		
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
		clientes.add(c4);
	}
	
	@GetMapping
	public List<Cliente> getClients() {
		return clientes;
	}
	
	@GetMapping("/{username}")
	public Cliente getClient(@PathVariable String username) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getUsername().equalsIgnoreCase(username)) {
				return cliente;
			}
		}
		return null;
	}

	@PostMapping
	public Cliente addClient(@RequestBody Cliente newClient) {

		clientes.add(newClient);
		return newClient;
	}

	@PutMapping("/{id}")
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

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClient(@PathVariable int id) {

		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				clientes.remove(cliente);
				return ResponseEntity.ok("Cliente eliminado");
				// Solo se puede hacer un .remove si uso un while, si uso un foreach hay que hacer un iterador.
			}
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
	}

	@PatchMapping("/{id}")
	public Cliente updateSmallClient(@PathVariable int id, @RequestBody Cliente updateClient) {
		for (Cliente cliente : clientes) {
			if (cliente.getId() == id) {
				
				if(updateClient.getName() != null) {
					cliente.setName(updateClient.getName());
				}
				
				if(updateClient.getUsername() != null) {
					cliente.setUsername(updateClient.getUsername());
				}
				
				if(updateClient.getPassword() != null) {
					cliente.setPassword(updateClient.getPassword());
				}

				return cliente;
			}
		}

		return null;
	}
}
