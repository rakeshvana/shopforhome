package com.capstone.discount.service;


/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This is a interface class
 * 
 */

import java.util.List;

import com.capstone.discount.dto.CouponDTO;
import com.capstone.discount.entity.Coupon;

public interface ICouponService {
	
	public Coupon addCoupon(CouponDTO dto);
	public void deleteCoupon(Long couponId);
	public Coupon updateCoupon(CouponDTO dto,Long couponId);
	public List<Coupon> getCoupon();
	public Coupon getByuser(Long userId);
	public void deleteByuser(Long userId);
	

}
