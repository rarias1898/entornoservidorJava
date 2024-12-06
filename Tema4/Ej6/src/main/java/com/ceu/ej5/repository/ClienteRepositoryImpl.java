package com.ceu.ej5.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej5.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Cliente> getClientes() {
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> listaClientes = query.getResultList();
		return listaClientes;
	}
	
	@Override
	public Cliente getCliente(int id) {
		Cliente client = entityManager.find(Cliente.class, id);
		return client;
	}

	@Override
	public Cliente addCliente(Cliente cliente) {
		entityManager.persist(cliente);
		
		return cliente;
	}

	@Override
	public void updateCliente(Cliente updatedCliente) {
		entityManager.merge(updatedCliente);
	}

	@Override
	public void deleteCliente(Cliente client) {
		entityManager.remove(client);
	}

	@Override
	public List<Cliente> getClientesByCiudad(String ciudad) {
		String jpql = "SELECT c FROM Cliente c WHERE c.direccion.ciudad = :ciudad";
		
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery(jpql, Cliente.class);
		
		query.setParameter("ciudad", ciudad);
		
		return query.getResultList();
	}

}
