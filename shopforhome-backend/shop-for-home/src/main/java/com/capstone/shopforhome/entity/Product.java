package com.capstone.shopforhome.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This Entity class is responsible for creating tables in database.
 */

@Entity

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pid;
	private String productName;
	private String productCategory;
	private String productDescription;
	private Long productStock;
	private Double productPrice;
	private String productImage;
	
	
	public Product() {}
	
	@OneToMany(
			mappedBy="product",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<Orders> orders = new ArrayList<>();
	
	@OneToMany(
			mappedBy="product",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<CartItem> cartItems = new ArrayList<>();
	
	@OneToMany(
			mappedBy="product",
			cascade = CascadeType.ALL,
		    orphanRemoval = true
			)
	@JsonIgnore
	private List<Wishlist> wishlist = new ArrayList<>();
	


	public Product(Long pid, String productName, String productCategory, String productDescription, Long productStock,
			Double productPrice, String productImage) {

		this.pid = pid;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productStock = productStock;
		this.productPrice = productPrice;
		this.productImage = productImage;
	}
	public Product(String productName, String productCategory, String productDescription, Long productStock,
			Double productPrice, String productImage) {
		
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
