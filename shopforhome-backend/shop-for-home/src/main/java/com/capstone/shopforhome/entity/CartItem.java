package com.capstone.shopforhome.entity;


/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This Entity class is responsible for creating tables in database.
 */


import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	private int quantity;

	public long getCart_Id() {
		return cartId;
	}

	public void setCart_Id(long cartId) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

	
	
	
	

}
