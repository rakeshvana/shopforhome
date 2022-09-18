package com.capstone.shopforhome.vo.request;

import java.time.LocalDate;

/*
 * @Author:rakesh
 * Modified Date:30-08-2022
 * Description:This class is a pojo for OrderProduct
 * 
 */

public class OrderProduct {
	

	
	private Long productId;
	
	private Long userId;
	
	private Long quantity;
	private Double price;
	private LocalDate orderDate;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public OrderProduct(Long productId, Long userId, Long quantity, Double price, LocalDate orderDate) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	public OrderProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

}
