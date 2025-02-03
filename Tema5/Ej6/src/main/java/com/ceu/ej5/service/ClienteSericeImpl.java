package com.ceu.ej5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceu.ej5.model.Cliente;
import com.ceu.ej5.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteSericeImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> getClientes() {
		 return repository.getClientes();
	}
	
	@Override
	public Cliente getCliente(int id) {
		return repository.getCliente(id);
	}

	@Transactional
	@Override
	public Cliente addCliente(Cliente cliente) {
		return repository.addCliente(cliente);
	}

	@Transactional
	@Override
	public void updateCliente(Cliente updatedCliente) {
		
		Cliente miCliente = getCliente(updatedCliente.getId());
		
		if (miCliente != null) {
			if (updatedCliente.getNombre() != null) {
				miCliente.setNombre(updatedCliente.getNombre());
			}
			
			if (updatedCliente.getDireccion().getCalle() != null) {
				miCliente.getDireccion().setCalle(updatedCliente.getDireccion().getCalle());;
			}
			
			if (updatedCliente.getDireccion().getCiudad() != null) {
				miCliente.getDireccion().setCiudad(updatedCliente.getDireccion().getCiudad());
			}
		}
		
		repository.updateCliente(miCliente);
	}

	@Transactional
	@Override
	public void deleteCliente(int id) {
		Cliente client = getCliente(id);
		
		repository.deleteCliente(client);
	}

	@Transactional
	@Override
	public void updateDireccion(int id, Cliente updatedCliente) {
		Cliente miCliente = getCliente(id);
		
		if (miCliente != null) {
			if (updatedCliente.getDireccion().getCalle() != null) {
				miCliente.getDireccion().setCalle(updatedCliente.getDireccion().getCalle());
			}
			
			if (updatedCliente.getDireccion().getCiudad() != null) {
				miCliente.getDireccion().setCiudad(updatedCliente.getDireccion().getCiudad());
			}
		}
		
		repository.updateCliente(miCliente);
		
	}

	@Transactional
	@Override
	public void updateToSevilla() {
		List<Cliente> listaClientes = getClientes().stream().filter(x -> x.getNombre().startsWith("a") || x.getNombre().startsWith("A")).toList();
		
		for (Cliente cliente : listaClientes) {
			cliente.getDireccion().setCiudad("Sevilla");
			repository.updateCliente(cliente);
		}
	}

	@Transactional
	@Override
	public void updateWithParameters(String letra, String ciudad) {
		List<Cliente> listaClientes = getClientes().stream().filter(x -> x.getNombre().startsWith(letra)).toList();
		
		for (Cliente cliente : listaClientes) {
			cliente.getDireccion().setCiudad(ciudad);
			repository.updateCliente(cliente);
		}
		
	}

	@Override
	public List<Cliente> getClientesByCiudad(String ciudad) {
		return repository.getClientesByCiudad(ciudad);
	}
}
