package com.capstone.shopforhome.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.repository.OrderRepo;
import com.capstone.shopforhome.repository.ProductRepository;

@SpringBootTest
class OrderServiceImplTest {
	
	@Autowired
	private OrderRepo repo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private IProductService productService;
	
	List<CartItem> orderItems = new ArrayList<>();
	
	 Product product = new Product("curatins","home","soe",3L,(double) 23,"image.jpg");
	
	@Test
	void testAddOrder() {
		for(CartItem item:orderItems) {
			Orders order = new Orders();
			order.setProduct(item.getProduct());
			order.setUser(item.getUser());
			order.setOrderDate(LocalDate.now());
			order.setPrice(item.getProduct().getProductPrice()*item.getQuantity()+10);
			order.setQuantity((long) item.getQuantity());
			
			//decreasing the stock
			Product product = productService.getProductById(item.getProduct().getPid());
			product.setProductStock(product.getProductStock()-item.getQuantity());
			
			productRepo.save(product);
			
			
			repo.save(order);
			}
			
			
	}

	@Test
	void testGetOrder() {
		repo.findAll();
	}

	@Test
	void testGetOrdersByProduct() {
		repo.findByProduct(product);
	}

	@Test
	void testGetByDate() {
		repo.findByOrderDateBetween(LocalDate.parse("2022-08-30"), LocalDate.parse("2022-0822"));
	}

	@Test
	void testGetByDateAndProduct() {
		repo.findByOrderDateBetweenAndProducts(LocalDate.parse("2022-08-30"),LocalDate.parse("2022-0822"), 1L);
	}

}
