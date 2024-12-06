package com.ceu.ej5.repository;

import java.util.List;

import com.ceu.ej5.model.Cliente;

public interface ClienteRepository {

	List<Cliente> getClientes();

	Cliente getCliente(int id);
	
	Cliente addCliente(Cliente cliente);

	void updateCliente(Cliente updatedCliente);

	void deleteCliente(Cliente client);

	List<Cliente> getClientesByCiudad(String ciudad);


}
