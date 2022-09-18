package com.capstone.shopforhome.dto;

import java.time.LocalDate;

import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
/*
 * @Author:Dyneshwari
 * Modified Date:30-08-2022
 * Description:This DTO class is responsible for transferring data to controller to service.
 */




public class OrderDTO {

	//private Long orderId;
	public OrderDTO( Product product, User user, Long quantity, Double price, LocalDate orderDate) {
		super();
		
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}

//	public Long getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Long orderId) {
//		this.orderId = orderId;
//	}

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

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
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

	private Product product;
	private User user;
	private Long quantity;
	private Double price;
	private LocalDate orderDate;
	
	public OrderDTO() {
		
	}


	
	
}
