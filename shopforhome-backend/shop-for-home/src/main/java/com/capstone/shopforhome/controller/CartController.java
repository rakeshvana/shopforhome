package com.capstone.shopforhome.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.service.ICartService;
import com.capstone.shopforhome.service.IProductService;
import com.capstone.shopforhome.service.IUserService;
import com.capstone.shopforhome.vo.request.ProductToCart;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IProductService productService;
	
	
	
	
	@GetMapping("/{userId}/cart")
	public List<CartItem> showCart(@PathVariable("userId") long userId){
		User user=userService.getUserById(userId);
		if(IUserService.map.containsKey(user.getEmail())) {
			
			return cartService.listCartItems(user);
		}
		
		return null;
	}
	
	@PostMapping("/{userId}/cart/add")
	public Integer addProductToCart(@PathVariable("userId") long userId,
			@RequestBody ProductToCart ptc ){
			
			User user=userService.getUserById(userId);
			System.out.println("userrrrrr"+user.getEmail());
			Product product = productService.getProductById(ptc.getProductId());
			System.out.println("productttt"+product.getProductName());
			if(IUserService.map.containsKey(user.getEmail())){
				
				return cartService.addProductToCart(product,user,1);
		}
			return null;
		
	}
	
	@DeleteMapping("/{userId}/cart/delete/{pid}")
	public Integer deleteProductFromCart(@PathVariable("pid") long productId,
										@PathVariable("userId") long userId) {
		User user=userService.getUserById(userId);
		Product product = productService.getProductById(productId);
		
		if(IUserService.map.containsKey(user.getEmail())){
			
			return cartService.deleteByUserAndProduct(user, product);
			
		
		}
		return null;
	}
	@GetMapping("{userId}/cart/cartcount")
	public Integer getCartCount() {
		return cartService.getCartCount();
		
	}
}
