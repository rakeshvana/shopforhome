package com.capstone.discount.dto;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This dto class is responsible for transfering the data 
 * 
 */

public class CouponDTO {

	
	private String couponName;
	private Double percentage;
	private Long userId;
	
	public CouponDTO() {
		
	}

	public CouponDTO( String couponName, Double percentage,Long id) {
		
		//this.couponId = couponId;
		this.couponName = couponName;
		this.percentage = percentage;
		this.userId=id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

//	public Long getCouponId() {
//		return couponId;
//	}
//
//	public void setCouponId(Long couponId) {
//		this.couponId = couponId;
//	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	
	
	
}
