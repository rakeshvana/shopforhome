package com.capstone.shopforhome.vo.request;

/*
 * @Author:chaitanya
 * Modified Date:30-08-2022
 * Description:This class is a pojo for ProductToCart
 * 
 */

public class ProductToCart {
	
	
	
	private long productId;
	private long quantity;
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public ProductToCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
