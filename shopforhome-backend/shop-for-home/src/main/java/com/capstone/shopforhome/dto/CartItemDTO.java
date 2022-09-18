package com.capstone.shopforhome.dto;

/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This DTO class is responsible for transferring data to controller to service.
 */

import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;

public class CartItemDTO {
	
	private long cart_Id;
	private Product product;
	private User user;
	private int quantity;
	
	public CartItemDTO() {
		
	}
	
	public CartItemDTO(long cart_Id, Product product, User user, int quantity) {
		super();
		this.cart_Id = cart_Id;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
	}
	
	public long getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(long cart_Id) {
		this.cart_Id = cart_Id;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
