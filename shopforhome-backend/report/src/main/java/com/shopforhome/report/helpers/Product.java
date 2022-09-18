package com.shopforhome.report.helpers;

/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This Entity class is used to create table in database
 * 
 */

public class Product {
	private Long pid;
	private String productName;
	private String productCategory;
	private String productDescription;
	private Long productStock;
	private Double productPrice;
	private String productImage;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long pid, String productName, String productCategory, String productDescription, Long productStock,
			Double productPrice, String productImage) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productStock = productStock;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Long getProductStock() {
		return productStock;
	}
	public void setProductStock(Long productStock) {
		this.productStock = productStock;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	
}
