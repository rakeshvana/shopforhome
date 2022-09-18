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
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;
import com.capstone.shopforhome.service.IProductService;
import com.capstone.shopforhome.service.IUserService;
import com.capstone.shopforhome.service.IWishlistService;
import com.capstone.shopforhome.vo.request.ProductToWishlist;


/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WishlistController {
	@Autowired
	IWishlistService wishlistService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IProductService productService;
	
	@GetMapping("/{userId}/wishlist")
	public List<Wishlist> showCart(@PathVariable("userId") long userId){
		User user=userService.getUserById(userId);
		if(IUserService.map.containsKey(user.getEmail())) {
			
			return wishlistService.listWishlistItems(user);
		}
		
		return null;
	}
	
	@PostMapping("/{userId}/wishlist/add")
	public Integer addProductToWhishlist(@RequestBody ProductToWishlist productId,
									@PathVariable("userId") long userId){
			User user=userService.getUserById(userId);
			Product product = productService.getProductById(productId.getProductId());
			
			if(IUserService.map.containsKey(user.getEmail())){
			
				return wishlistService.addProductToWishlist(product,user);
		}
			return null;
		
	}
	
	@DeleteMapping("/{userId}/wishlist/delete/{pid}")
	public Integer deleteProductFromWishlist(@PathVariable("pid") long productId,
										@PathVariable("userId") long userId) {
		User user=userService.getUserById(userId);
		Product product = productService.getProductById(productId);
		
		if(IUserService.map.containsKey(user.getEmail())){
			
			return wishlistService.deleteByUserAndProduct(user, product);
		
	}
		return null;
	}
	
	@GetMapping("{userId}/wishlist/wishlistcount")
	public Integer getWishlistCount() {
		return wishlistService.getWishlistCount();
		
	}
	
	

}
