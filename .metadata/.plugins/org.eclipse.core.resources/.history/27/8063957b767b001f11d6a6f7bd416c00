package com.ej2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public Cliente getClient(@RequestParam String username) {
		
		for (Cliente cliente : clientes) {
			if(cliente.getUsername().equalsIgnoreCase(username)) {
				return cliente;
			}
		}
		
		return null;
	}
}
