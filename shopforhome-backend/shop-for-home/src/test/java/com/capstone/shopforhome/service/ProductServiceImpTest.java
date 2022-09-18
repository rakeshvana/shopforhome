package com.capstone.shopforhome.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.repository.ProductRepository;


@SpringBootTest
class ProductServiceImpTest {

	@Autowired
	private ProductRepository repo;
	
	@Test
	void testAddProduct() {
		Product product = new Product("Flowers With Leaf Metal Sculpture","Table Decor","Good Product",150L,120D,"tabledecor5.jpg");
		repo.save(product);
		assertNotNull(product);
	}

	@Test
	void testDeleteProduct() {
		repo.deleteById(6L);
		Product p = repo.findById(6L).orElse(null);
		assertNull(p);
	}

	@Test
	void testUpdateProduct() {
		Product p = repo.findById(1L).get();
		p.setProductPrice(1200D);
		repo.save(p);
		assertEquals(1200D,repo.findById(1L).get().getProductPrice());
		
	}

	@Test
	void testGetProduct() {
		List<Product> p = repo.findAll();
		assertTrue(p.size()>0);
	}

	@Test
	void testGetProductById() {
		Product p = repo.findById(1L).get();
		assertNotNull(p);
	}

	@Test
	void testGetAllIds() {
		List<Long> ids = repo.getAllIds();
		assertTrue(ids.size()>0);
	}

}
