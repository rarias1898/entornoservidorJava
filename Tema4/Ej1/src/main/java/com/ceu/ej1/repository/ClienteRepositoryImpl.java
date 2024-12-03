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
		
		client.setNombre(cliente.getNombre());
		client.setApellidos(cliente.getApellidos());
		
		entityManager.merge(client);
	}

	public void ActualizarClienteParcial(int id, Cliente editClient) {
		Cliente client = getCliente(id);
		
		if(editClient.getNombre() != null) {
			client.setNombre(editClient.getNombre());
		}
		
		if(editClient.getApellidos() != null) {
			client.setApellidos(editClient.getApellidos());
		}
		
		entityManager.merge(client);
	}

	public Cliente getClientesNombre(String nombre) {
		String jpql = "SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre";
		
		Query<Cliente> query = (Query<Cliente>) entityManager.createQuery(jpql, Cliente.class);
		query.setParameter("nombre", "%" + nombre + "%");
		
		return query.getSingleResult();
	}
}
