package com.capstone.shopforhome.service;

import java.util.List;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */



public interface ICartService {
	
	public List<CartItem> listCartItems(User user);
	public Integer addProductToCart(Product product,User user, int Quantity );
	public Integer deleteByUserAndProduct(User user, Product product);
	public void deleteById(Long cartId);
	public Integer getCartCount() ;
	

}
