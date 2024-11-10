package com.ceu.ej3.repository;

import com.ceu.ej3.model.Vehiculo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class VehiculoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehiculo addVehiculo(Vehiculo vehiculo) {
        entityManager.persist(vehiculo);
        return vehiculo;
    }

    public Vehiculo getVehiculoById(int id) {
        Vehiculo vehiculo = entityManager.find(Vehiculo.class, id);
        return vehiculo;
    }

	public List<Vehiculo> getVehiculos() {
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.createQuery("select v from Vehiculo v", Vehiculo.class);
		List<Vehiculo> listaVehiculos = query.getResultList();
		return listaVehiculos;
	}

	public void updateVehiculo(Vehiculo updatedVehiculo) {
		Vehiculo vehiculo = getVehiculoById(updatedVehiculo.getId());
		
		vehiculo.setMarca(updatedVehiculo.getMarca());
		vehiculo.setModelo(updatedVehiculo.getModelo());
		vehiculo.setAnyo(updatedVehiculo.getAnyo());
		vehiculo.setEstado(updatedVehiculo.getEstado());
		vehiculo.setMatricula(updatedVehiculo.getMatricula());
		vehiculo.setKilometraje(updatedVehiculo.getKilometraje());
		
		entityManager.persist(vehiculo);
	}

	public void deleteVehiculo(int id) {
		Vehiculo vehiculo = getVehiculoById(id);
		
		entityManager.remove(vehiculo);
	}

	public Vehiculo updateEstado(int id, Vehiculo updatedVehiculo) {
		Vehiculo vehiculo = getVehiculoById(id);
		
		if (updatedVehiculo.getEstado() != null) {
			vehiculo.setEstado(updatedVehiculo.getEstado());
		}
		
		entityManager.merge(vehiculo);
		return vehiculo;
	}

	public Vehiculo updateKm(int id, Vehiculo updateVehiculo) {
		Vehiculo vehiculo = getVehiculoById(id);
		
		if(updateVehiculo.getKilometraje() != null) {
			vehiculo.setKilometraje(updateVehiculo.getKilometraje());
		}
		
		entityManager.merge(vehiculo);
		return vehiculo;
	}

	public List<Vehiculo> getVehiculosByEstado(String estado) {
		String jpql = "SELECT v FROM Vehiculo v WHERE v.estado LIKE :estado";
		
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.createQuery(jpql, Vehiculo.class);
		query.setParameter("estado", "%" + estado + "%");
		
		return query.getResultList();
	}

	public List<Vehiculo> getVehiculosByYear(int anyoInicio, int anyoFin) {
		String jpql = "SELECT v FROM Vehiculo v WHERE v.anyo >= :anyoInicio AND v.anyo <= :anyoFin";
		
		Query<Vehiculo> query = (Query<Vehiculo>) entityManager.createQuery(jpql, Vehiculo.class);
		query.setParameter("anyoInicio", anyoInicio);
	    query.setParameter("anyoFin", anyoFin);
		
	    return query.getResultList();
	}
}
