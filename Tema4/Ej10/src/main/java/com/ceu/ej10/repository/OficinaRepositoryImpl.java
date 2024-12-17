package com.ceu.ej10.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej10.model.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class OficinaRepositoryImpl implements OficinaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addOficina(Oficina oficina) {
		entityManager.persist(oficina);
	}

	@Override
	public List<Oficina> getOficinas() {
		Query<Oficina> query = (Query<Oficina>) entityManager.createQuery("select o from Oficina o", Oficina.class);
		List<Oficina> listaOficinas = query.getResultList();
		
		return listaOficinas;
	}

	@Override
	public Oficina getOficinaById(int id) {
		return entityManager.find(Oficina.class, id);
	}

	@Override
	public void deleteOficina(Oficina oficina) {
		entityManager.remove(oficina);
	}
}
