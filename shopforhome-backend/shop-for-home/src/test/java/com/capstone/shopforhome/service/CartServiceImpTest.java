package com.capstone.shopforhome.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;
import com.capstone.shopforhome.repository.CartRepository;
@SpringBootTest
class CartServiceImpTest {
	

	@Autowired
	private CartRepository cartRepo;
	
	 List<Wishlist> wishlist = new ArrayList<>();
	 List<Orders> orders = new ArrayList<>();
	 List<CartItem> cartItems = new ArrayList<>();
	 Product product = new Product("curatins","home","soe",3L,(double) 23,"image.jpg");
	User user = new User("1,rakesh@gamil.com","rakesh","vizag",1234,"123","USER",wishlist,orders,cartItems);

	
	@Test
	void testListCartItems() {
		
		
		User u = user;
		cartRepo.findByUser(u);
		assertNotNull(u);
	}

	@Test
	void testAddProductToCart() {
		
		int finalQuantity =3;
		CartItem cartItem = cartRepo.findByUserAndProduct(user, product);
		if(cartItem==null) {
			CartItem cItem = new CartItem();
			cItem.setQuantity(3);
			cItem.setProduct(product);
			cItem.setUser(user);
			cartRepo.save(cItem);
			
		}
		else {
			finalQuantity = cartItem.getQuantity()+3;
			cartItem.setQuantity(finalQuantity);
			cartRepo.save(cartItem);
		}
		assertNotNull(cartItem);
	}

	@Test
	void testDeleteByUserAndProduct() {
		Long cartId= cartRepo.findByUserAndProduct(user, product).getCart_Id();
		
		cartRepo.deleteById(cartId);
		
		
		
	}

	@Test
	void testDeleteById() {
		cartRepo.deleteById(1L);
	}

	@Test
	void testGetCartCount() {
		cartRepo.count();
	}

}
