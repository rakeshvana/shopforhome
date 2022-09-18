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
import com.capstone.shopforhome.repository.UserRepository;

@SpringBootTest
class UserServiceImpTest {
	
	@Autowired
	UserRepository userRepository;

	 List<Wishlist> wishlist = new ArrayList<>();
	 List<Orders> orders = new ArrayList<>();
	 List<CartItem> cartItems = new ArrayList<>();
	User user = new User("1,rakesh@gamil.com","rakesh","vizag",1234,"123","USER",wishlist,orders,cartItems);


	@Test
	void testRegisterUser() {
		User u = user;
		userRepository.save(u);
		assertNotNull(u);
	}

	@Test
	void testLoginUser() {
		fail("Not yet implemented");
	}

	@Test
	void testLogoutUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllUsers() {
		List<User> u = userRepository.findAll();
		assertTrue(u.size()>0);
		
	}

	@Test
	void testUpdateUser() {
		User u = userRepository.findById(1L).get();
		u.setPassword("12345");
		userRepository.save(u);
		assertEquals("12345",userRepository.findById(1L).get().getPassword());
	}

	@Test
	void testRemoveUser() {
		userRepository.deleteById(2L);
		User  u = userRepository.findById(2L).orElse(null);
		assertNull(u);
	}

	@Test
	void testGetUserById() {
		User u = userRepository.findById(1L).get();
		assertNotNull(u);
	}

	

}
