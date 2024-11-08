package com.ceu.ej1.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej1.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Cliente> getClientes() {
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	
	public void addCliente(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public Cliente getCliente(int id) {
		Cliente cliente = entityManager.find(Cliente.class, id);
		return cliente;
	}

	public void deleteCliente(int id) {
		Cliente client = getCliente(id);
		entityManager.remove(client);
	}

	public void actualizarCliente(int id, Cliente cliente) {
		Cliente client = getCliente(id);
		
		
		entityManager.merge(client);
	}
}
