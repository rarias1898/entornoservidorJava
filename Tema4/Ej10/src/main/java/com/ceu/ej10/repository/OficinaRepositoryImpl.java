package com.ceu.ej10.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej10.model.Empleado;
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

	@Override
	public long countEmpleadosOficina(int id) {
		String jpql = "SELECT e FROM Empleado e WHERE e.oficina.id = :id";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class);
		query.setParameter("id", id);
		return query.getResultCount();
	}

	@Override
	public List<Oficina> getOficinaConMasDeNEmpleados(int numEmpleados) {
		return null;
	}
}
