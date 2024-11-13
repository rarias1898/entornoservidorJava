package com.ceu.ej2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = service.getProducts();
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product p = service.getProductById(id);
		
		if (p == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> editTotalProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		updatedProduct.setId(id);
		service.editTotalProduct(updatedProduct);
		
		return ResponseEntity.noContent().build();
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> editParcialProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		Product miProduct = service.getProductById(id);
		
		if (miProduct == null) {
			return ResponseEntity.noContent().build();
		}
		
		if (updatedProduct.getName() != null) {
			miProduct.setName(updatedProduct.getName());
		}
		
		if (updatedProduct.getPrice() != 0) {
			miProduct.setPrice(updatedProduct.getPrice());
		}
		
		service.editParcialProduct(miProduct);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		service.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/by-name/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {
		List<Product> listaProductos = service.getProductByName(name);
		
		if (listaProductos == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(listaProductos);
	}
	
	@GetMapping("/by-price/{price1}/{price2}")
	public ResponseEntity<List<Product>> getProductByPriceRange(@PathVariable int price1, @PathVariable int price2) {
		List<Product> listaProductos = service.getProductByPriceRange(price1, price2);
		
		if (listaProductos == null) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(listaProductos);
	}
	
	@PostMapping("/product-list")
	public ResponseEntity<List<Product>> addProductList() {
		return null;
	}
}
