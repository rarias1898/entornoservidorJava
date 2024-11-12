package com.ceu.ej2.repository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.ceu.ej2.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public Product addProduct(Product newProduct) {
		entityManager.persist(newProduct);
		return newProduct;
	}

	public List<Product> getProducts() {
		
	}
}
