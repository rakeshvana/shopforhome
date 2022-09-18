package com.shopforhome.report.entity;

/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This Entity class is used to create table in database
 * 
 */

public class Report {
	
	private Long productId;
	private String productName;
	private String productCategory;
	private double price;
	private Long currentStock;
	private Long orderedAmount;
	private double profit;
	private String productImage;
	
	
	public Report(Long productId, String productName, String productCategory, double price, Long currentStock,
			Long orderedAmount, double profit, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.currentStock = currentStock;
		this.orderedAmount = orderedAmount;
		this.profit = profit;
		this.productImage = productImage;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(Long currentStock) {
		this.currentStock = currentStock;
	}
	public Long getOrderedAmount() {
		return orderedAmount;
	}
	public void setOrderedAmount(Long orderedAmount) {
		this.orderedAmount = orderedAmount;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	

}
