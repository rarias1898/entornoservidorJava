package com.ceu.ej15.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej15.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CursoRepositoryImpl implements CursoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Curso c1) {
		if (c1.getId() == null) {
			entityManager.persist(c1);
		}else {
			entityManager.merge(c1);
		}
		
	}

	@Override
	public List<Curso> getCursos() {
		Query<Curso> query = (Query<Curso>) entityManager.createQuery("select c from Curso c", Curso.class);
		List<Curso> listaCursos = query.getResultList();
		return listaCursos;
	}

	@Override
	public Curso getCursoById(Integer id) {
		Curso curso = entityManager.find(Curso.class, id);
		return curso;
	}

	@Override
	public List<Curso> getCursoByWord(String string) {
		String jpql = "SELECT c FROM Curso c WHERE c.nombre LIKE :string";
		Query<Curso> query = (Query<Curso>) entityManager.createQuery(jpql, Curso.class);
		query.setParameter("string", "%" + string + "%" );
		return query.getResultList();
	}
}
