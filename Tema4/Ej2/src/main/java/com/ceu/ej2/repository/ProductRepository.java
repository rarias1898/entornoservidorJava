package com.ceu.ej2.repository;

import java.util.List;

import org.hibernate.query.Query;
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
		Query<Product> query = (Query<Product>) entityManager.createQuery("select p from Product p", Product.class);
		List<Product> listaProductos = query.getResultList();
		return listaProductos;
	}

	public Product getProductById(int id) {
		Product product = entityManager.find(Product.class, id);
		return product;
	}

	public void editTotalProduct(Product updatedProduct) {
		entityManager.merge(updatedProduct);
	}

	public void editParcialProduct(Product updatedProduct) {
		entityManager.merge(updatedProduct);
	}

	public void deleteProduct(int id) {
		Product p = entityManager.find(Product.class, id);
		
		if (p != null) {
			entityManager.remove(p);
		}
	}

	public List<Product> getProductByName(String name) {
		String jpql = "SELECT p FROM Product p WHERE p.name LIKE :name";
		Query<Product> query = (Query<Product>) entityManager.createQuery(jpql, Product.class);
		
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}

	public List<Product> getProductByPriceRange(int price1, int price2) {
		String jpql = "SELECT p FROM Product p WHERE p.price >= :price1 AND p.price <= :price2";
		Query<Product> query = (Query<Product>) entityManager.createQuery(jpql, Product.class);
		
		query.setParameter("price1", price1);
		query.setParameter("price2", price2);
		
		return query.getResultList();
	}

	public List<Product> addProductList(List<Product> listaProductos) {
		for(Product product : listaProductos) {
			entityManager.merge(product);
		}
		return listaProductos;
	}
}
