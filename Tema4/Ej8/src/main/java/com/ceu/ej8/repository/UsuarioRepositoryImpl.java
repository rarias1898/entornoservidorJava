package com.ceu.ej8.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej8.model.Perfil;
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

	@Override
	public Perfil getPerfil(int id) {
		String jpql = "SELECT u.perfil FROM Usuario u WHERE u.id = :id";
		Query<Perfil> query = (Query<Perfil>) entityManager.createQuery(jpql, Perfil.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Usuario> getUsuariosContainsEdad() {
		String edad = "edad";
		String jpql = "SELECT u FROM Usuario u WHERE u.perfil.bio LIKE :edad";
		Query<Usuario> query = (Query<Usuario>) entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("edad", "%" + edad + "%");
		return query.getResultList();
	}
}
