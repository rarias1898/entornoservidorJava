package com.ceu.ej1.service;

import java.util.List;

import com.ceu.ej1.model.Cliente;

public interface ClienteService {
	List<Cliente> getClientes();
	
	void addCliente(Cliente cliente);
	
	Cliente getCliente(int id);
	
	void deleteCliente(int id);
	
	void actualizarCliente(int id, Cliente cliente);
	
	void actualizarClienteParcial(int id, Cliente editClient);
	
	Cliente getClientesNombre(String nombre);
}
