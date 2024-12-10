package com.ceu.ej5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ceu.ej5.model.Cliente;
import com.ceu.ej5.model.Direccion;
import com.ceu.ej5.service.ClienteService;

@SpringBootApplication
public class Ej6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ej6Application.class, args);
	}
	
	@Autowired
	ClienteService service;

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		cliente1.setNombre("Pepe Ruiz");
		cliente2.setNombre(" Andres Ramirez");
		
		Direccion dir1 = new Direccion();
		Direccion dir2 = new Direccion();
		dir1.setCalle("Sol");
		dir1.setCiudad("Oviedo");
		dir2.setCalle("Mar");
		dir2.setCiudad("Cadiz");
		
		cliente1.setDireccion(dir1);
		cliente2.setDireccion(dir2);
		
		// Añadir un cliente.
		// service.addCliente(cliente1);
		
		
		// Mostrar un cliente por su id.
		System.out.println(service.getCliente(cliente1.getId()));
		
		// Mostrar la lista de clientes.
		List<Cliente> listaClientes = service.getClientes();
		for (Cliente cliente : listaClientes) {
			System.out.println(cliente);
		}
	}

}
