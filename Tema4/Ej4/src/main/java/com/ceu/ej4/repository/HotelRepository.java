package com.ceu.ej4.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej4.model.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class HotelRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Hotel addHotel(Hotel nuevoHotel) {
		entityManager.persist(nuevoHotel);
		return nuevoHotel;
	}

	public List<Hotel> getHotels() {
		Query<Hotel> query = (Query<Hotel>) entityManager.createQuery("select h from Hotel h", Hotel.class);
		List<Hotel> listaHoteles = query.getResultList();
		
		return listaHoteles;
	}

	public Hotel getHotelById(int id) {
		Hotel hotel = entityManager.find(Hotel.class, id);
		
		return hotel;
	}

	public void updateHotelByid(Hotel updatedHotel) {
		entityManager.merge(updatedHotel);
	}

	public void deleteHotelById(Hotel hotel) {
		entityManager.remove(hotel);
	}

	public List<Hotel> getHotelesByEstrellas(int eMin, int eMax) {
		String jpql = "SELECT h FROM Hotel h WHERE h.estrellas BETWEEN :eMin AND :eMax";
		Query<Hotel> query = (Query<Hotel>) entityManager.createQuery(jpql, Hotel.class);
		
		query.setParameter("eMax", eMax);
		query.setParameter("eMin", eMin);
		
		return query.getResultList();
	}
}
