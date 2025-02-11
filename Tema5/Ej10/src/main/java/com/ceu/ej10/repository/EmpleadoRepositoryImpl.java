package com.ceu.ej10.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej10.model.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEmpleado(Empleado newEmpleado) {
		entityManager.persist(newEmpleado);
	}

	@Override
	public List<Empleado> getEmpleados() {
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery("select e from Empleado e", Empleado.class);
		List<Empleado> listaEmpleados = query.getResultList();
		return listaEmpleados;
	}

	@Override
	public Empleado getEmpleadoById(int id) {
		return entityManager.find(Empleado.class, id);
	}

	@Override
	public void updateEmpleado(Empleado miEmpleado) {
		entityManager.merge(miEmpleado);
	}

	@Override
	public void deleteEmpleado(Empleado empleado) {
		entityManager.remove(empleado);
	}

	@Override
	public List<Empleado> getEmpleadoByPuesto(String puesto) {
		String jpql = "SELECT e FROM Empleado e WHERE e.puesto LIKE :puesto";
		Query<Empleado> query = (Query<Empleado>) entityManager.createQuery(jpql, Empleado.class);
		query.setParameter("puesto", "%" + puesto + "%");
		
		return query.getResultList();
	}
}
