package com.ceu.ej12.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej12.model.Autor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class AutorRepositoryImpl implements AutorRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Autor> getAutores() {
		Query<Autor> query = (Query<Autor>) entityManager.createQuery("select a from Autor a", Autor.class);
		List<Autor> listaAutores = query.getResultList();
		return listaAutores;
	}

	@Override
	public void addAutor(Autor a1) {
		entityManager.persist(a1);
	}

	@Override
	public Autor getAutorById(int id) {
		Autor autor = entityManager.find(Autor.class, id);
		return autor;
	}

	@Override
	public Autor updateAutor(Autor autor1) {
		Autor autor = entityManager.merge(autor1);
		return autor;
	}

	@Override
	public void deleteAutor(Autor autor) {
		entityManager.remove(autor);
		
	}

}
