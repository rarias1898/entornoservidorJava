package com.ceu.ej8.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej8.model.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Usuario> getUsuarios() {
		Query<Usuario> query = (Query<Usuario>) entityManager.createQuery("select u from Usuario u", Usuario.class);
		List<Usuario> listaUsuarios = query.getResultList();
		return listaUsuarios;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		return usuario;
	}

	@Override
	public void addUsuario(Usuario usuario) {
		entityManager.persist(usuario);
	}

	@Override
	public void updateUsuario(Usuario miUsuario) {
		entityManager.merge(miUsuario);
		
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		entityManager.remove(usuario);
		
	}
}
