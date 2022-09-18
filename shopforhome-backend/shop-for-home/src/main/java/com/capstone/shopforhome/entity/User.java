package com.capstone.shopforhome.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.capstone.shopforhome.entity.CartItem;
import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * @Author:Dyaneshwari
 * Modified Date:30-08-2022
 * Description:This Entity class is responsible for creating tables in database.
 */

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String email;
	private String name;
	private String address;
	private long contactNumber;
	private String password;
	private String role;
	
//	@OneToOne(mappedBy="user"
//		    )
//	private Coupon coupon;
//	
	@OneToMany(
			mappedBy="user",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<CartItem> cartItems = new ArrayList<>();
	
	@OneToMany(
			mappedBy="user",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<Orders> orders = new ArrayList<>();
	
	@OneToMany(
			mappedBy="user",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<Wishlist> wishlist = new ArrayList<>();


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(long userId, String email, String name, String address, long contactNumber, String password,
			String role, List<CartItem> cartItems, List<Orders> orders, List<Wishlist> wishlist) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
		this.cartItems = cartItems;
		this.orders = orders;
		this.wishlist = wishlist;
		//this.coupon=coupon;
	}
	
	public User( String email, String name, String address, long contactNumber, String password,
			String role, List<Wishlist> wishlist, List<Orders> orders, List<CartItem> cartItems) {
		super();
		this.email = email;
		this.name = name;
		this.address = address;
		this.contactNumber = contactNumber;
		this.password = password;
		this.role = role;
		this.cartItems = cartItems;
		this.orders = orders;
		this.wishlist = wishlist;
		//this.coupon=coupon;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
//	
//	public Coupon getCoupon() {
//		return coupon;
//	}
//
//
//	public void setCoupon(Coupon coupon) {
//		this.coupon = coupon;
//	}
//


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}


	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}


	public List<Orders> getOrders() {
		return orders;
	}


	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	public List<Wishlist> getWishlist() {
		return wishlist;
	}


	public void setWishlist(List<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}
	
	
	
	
	
	
}
