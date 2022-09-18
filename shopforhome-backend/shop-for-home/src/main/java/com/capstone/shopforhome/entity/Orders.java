package com.capstone.shopforhome.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This Entity class is responsible for creating tables in database.
 */

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	
	@ManyToOne()
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
	
	private Long quantity;
	private Double price;
	private LocalDate orderDate;
	
	
	public Orders() {}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long i) {
		this.quantity = i;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Orders(Long orderId) {
		super();
		this.orderId = orderId;
		//this.orderName = orderName;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
//	public String getOrderName() {
//		return orderName;
//	}
//	public void setOrderName(String orderName) {
//		this.orderName = orderName;
//	}
	
	

}
