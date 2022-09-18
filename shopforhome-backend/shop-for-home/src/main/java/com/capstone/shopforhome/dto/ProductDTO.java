package com.capstone.shopforhome.dto;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This DTO class is responsible for transferring data to controller to service.
 */



public class ProductDTO {
	private Long pid;
	private String productName;
	private String productCategory;
	private String productDescription;
	private Long productStock;
	private Double productPrice;
	private String productImage;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Long pid, String productName, String productCategory, String productDescription,
			Long productStock, Double productPrice, String productImage) {
		
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
