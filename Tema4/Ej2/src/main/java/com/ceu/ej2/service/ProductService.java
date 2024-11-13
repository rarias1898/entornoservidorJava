package com.ceu.ej2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Product getProductById(int id) {
		return repository.getProductById(id);
	}

	@Transactional
	public void editTotalProduct(Product updatedProduct) {
		repository.editTotalProduct(updatedProduct);
	}

	@Transactional
	public void editParcialProduct(Product updatedProduct) {
		repository.editParcialProduct(updatedProduct);
	}

	@Transactional
	public void deleteProduct(int id) {
		repository.deleteProduct(id);
	}

	public List<Product> getProductByName(String name) {
		return repository.getProductByName(name);
	}

	public List<Product> getProductByPriceRange(int price1, int price2) {
		return repository.getProductByPriceRange(price1, price2);
	}
}
