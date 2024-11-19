package com.ceu.ej5.repository;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ceu.ej5.model.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AnimalRepository {

	@PersistenceContext
	private EntityManager entityMananger;

	@Transactional
	public Animal addAnimal(Animal newAnimal) {
		entityMananger.persist(newAnimal);
		return newAnimal;
	}

	public List<Animal> getAnimales() {
		Query<Animal> query = (Query<Animal>) entityMananger.createQuery("select a from Animal a", Animal.class);
		List<Animal> listaAnimales = query.getResultList();
		return listaAnimales;
	}

	public Animal getAnimalById(int id) {
		return entityMananger.find(Animal.class, id);
	}

	public void updateAnimal(Animal updatedAnimal) {
		entityMananger.merge(updatedAnimal);
	}

	public void deleteAnimal(Animal animal) {
		entityMananger.remove(animal);
		
	}

	public List<Animal> getAnimalesByEspecie(String especie) {
		String jpql = "select a from Animal a where a.especie like :especie";
		
		Query<Animal> query = (Query<Animal>) entityMananger.createQuery(jpql, Animal.class);
		query.setParameter("especie", "%" + especie + "%");
		
		return query.getResultList();
	}

	public List<Animal> getAnimalesByEdad(int edad) {
		Query<Animal> query = (Query<Animal>) entityMananger.createQuery("select a from Animal a where a.edad = :edad", Animal.class);
		query.setParameter("edad", edad);
		List<Animal> listaAnimales = query.getResultList();
		return listaAnimales;
	}

	public List<Animal> getAnimalesRecientes(int anyo) {
		Query<Animal> query = (Query<Animal>) entityMananger.createQuery("select a from Animal a where year(a.fechaIngreso) >= :anyo", Animal.class);
		query.setParameter("anyo", anyo);
		List<Animal> listaAnimales = query.getResultList();
		return listaAnimales;
	}
}
