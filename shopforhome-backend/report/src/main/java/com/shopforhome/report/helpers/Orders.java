package com.shopforhome.report.helpers;
import java.time.LocalDate;

/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This Entity class is used to create table in database
 * 
 */

public class Orders {
	private Long orderId;
	private Product product;
	private User user;
	private Long quantity;
	private Double price;
	private LocalDate orderDate;
	
	
	public Long getOrderId() {
		return orderId;
	}
	public Orders(Long orderId, Product product, User user, Long quantity, Double price, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.user = user;
		this.quantity = quantity;
		this.price = price;
		this.orderDate = orderDate;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
