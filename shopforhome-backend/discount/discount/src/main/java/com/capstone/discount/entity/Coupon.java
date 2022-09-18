package com.capstone.discount.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This Entity class is responsible for creating the table in database
 * 
 */

@Entity
@Table(name="coupon")
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long couponId;
	private String couponName;
	private Double percentage;
	private Long userId;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Coupon() {
	
	}

	public Coupon(Long couponId, String couponName, Double percentage,Long userid) {
		
		this.couponId = couponId;
		this.couponName = couponName;
		this.percentage = percentage;
		this.userId=userid;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

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
