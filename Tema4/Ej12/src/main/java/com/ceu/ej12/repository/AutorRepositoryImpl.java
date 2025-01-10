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
		
		//return a1;
	}

}
