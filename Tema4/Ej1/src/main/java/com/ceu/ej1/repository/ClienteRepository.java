package com.ceu.ej1.repository;

import java.util.List;

import com.ceu.ej1.model.Cliente;

public interface ClienteRepository {
	List<Cliente> getClientes();
	
	void addCliente(Cliente cliente);
	
	Cliente getCliente(int id);
	
	void deleteCliente(int id);
	
	void actualizarCliente(int id, Cliente cliente);
	
	void ActualizarClienteParcial(int id, Cliente editClient);
	
	Cliente getClientesNombre(String nombre);
}
