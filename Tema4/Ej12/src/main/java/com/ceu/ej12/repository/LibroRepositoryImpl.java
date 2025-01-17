package com.ceu.ej12.repository;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class LibroRepositoryImpl implements LibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

}
