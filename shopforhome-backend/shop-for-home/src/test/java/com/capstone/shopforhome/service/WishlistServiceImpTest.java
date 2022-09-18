package com.capstone.shopforhome.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;
import com.capstone.shopforhome.repository.WishlistRepository;

class WishlistServiceImpTest {

	@Autowired
	private WishlistRepository wishlistRepo;
	
	 List<Wishlist> wishlist = new ArrayList<>();
	 List<Orders> orders = new ArrayList<>();
	 List<CartItem> cartItems = new ArrayList<>();
	 Product product = new Product("curatins","home","soe",3L,(double) 23,"image.jpg");
	User user = new User("1,rakesh@gamil.com","rakesh","vizag",1234,"123","USER",wishlist,orders,cartItems);

	
	@Test
	void testListWishlistItems() {
		wishlistRepo.findByUser(user);
	}

	@Test
	void testAddProductToWishlist() {
	Wishlist wishlistItem = wishlistRepo.findByUserAndProduct(user, product);
		
		if(wishlistItem==null) {
			Wishlist wItem = new Wishlist();
			wItem.setProduct(product);
			wItem.setUser(user);
			wishlistRepo.save(wItem);
				wishlistRepo.count();
		}
		else {
			 wishlistRepo.count();
		}
	}

	@Test
	void testDeleteByUserAndProduct() {
Long cartId= wishlistRepo.findByUserAndProduct(user, product).getId();
		
		wishlistRepo.deleteById(cartId);
		wishlistRepo.count();
	}


}
