package com.ceu.ej1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej1.model.Cliente;
import com.ceu.ej1.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> getClientes() {
		return repository.getClientes();
	}
	
	@Transactional
	public void addCliente(Cliente cliente) {
		repository.addCliente(cliente);
	}

	public Cliente getCliente(int id) {
		return repository.getCliente(id);
	}

	@Transactional
	public void deleteCliente(int id) {
		repository.deleteCliente(id);
	}

	@Transactional
	public void actualizarCliente(int id, Cliente cliente) {
		repository.actualizarCliente(id, cliente);
	}

	@Transactional
	public void actualizarClienteParcial(int id, Cliente editClient) {
		repository.ActualizarClienteParcial(id, editClient);
	}

	public Cliente getClientesNombre(String nombre) {
		return repository.getClientesNombre(nombre);
	}
}
