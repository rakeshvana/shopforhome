package com.capstone.shopforhome.service;

import java.util.List;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

public interface IWishlistService {
	
	public List<Wishlist> listWishlistItems(User user);
	public Integer addProductToWishlist(Product product,User user );
	public Integer deleteByUserAndProduct(User user, Product product);
	public Integer getWishlistCount() ;
	
	
	
}
