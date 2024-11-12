package com.ceu.ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceu.ej2.model.Product;
import com.ceu.ej2.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	@Transactional
	public Product addProduct(Product newProduct) {
		return repository.addProduct(newProduct);
	}

	public List<Product> getProducts() {
		return repository.getProducts();
	}
}
