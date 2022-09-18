package com.capstone.shopforhome.dto;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;

/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This DTO class is responsible for transferring data to controller to service.
 */



public class WishlistDTO {
	
	private long cartId;
	private Product product;
	private User user;
	
	public WishlistDTO() {}
	
	public WishlistDTO(long cartId, Product product, User user) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.user = user;
	}
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}

