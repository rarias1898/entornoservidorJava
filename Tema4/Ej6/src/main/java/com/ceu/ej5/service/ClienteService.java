package com.ceu.ej5.service;

import java.util.List;

import com.ceu.ej5.model.Cliente;

public interface ClienteService {

	List<Cliente> getClientes();

	Cliente getCliente(int id);
	
	Cliente addCliente(Cliente cliente);

	void updateCliente(Cliente updatedCliente);

	void deleteCliente(int id);

	void updateDireccion(int id, Cliente updatedCliente);

	void updateToSevilla(Cliente updatedClient);

}
