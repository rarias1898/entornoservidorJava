package com.ceu.ej2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceu.ej2.model.Product;
import com.ceu.ej2.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		Product p = service.addProduct(newProduct);
		return ResponseEntity.ok(p);
	}
	
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = service.getProducts();
		return ResponseEntity.ok(products);
	}
}
