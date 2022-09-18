package com.capstone.discount.controller;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This controller class is responsible for processing the incomming rest api requests
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.discount.dto.CouponDTO;
import com.capstone.discount.entity.Coupon;
import com.capstone.discount.service.ICouponService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CouponController {

	
	@Autowired
	private ICouponService iCouponService;
	
	@PostMapping("/addcoupon")
	public Coupon addCoupons(@RequestBody CouponDTO dto) {
		
		return iCouponService.addCoupon(dto) ;
	}
	
	@DeleteMapping("/deletecoupon/{couponid}")
	public String deleteCoupons(@PathVariable Long couponid) {
		iCouponService.deleteCoupon(couponid);
		return "Deleted Successfully";
	}
	
	@PutMapping("/updatecoupon/{couponid}")
	public Coupon updateCoupons(@RequestBody CouponDTO dto,@PathVariable Long couponid ) {
		return iCouponService.updateCoupon(dto, couponid);
	}
	
	@GetMapping("/getcoupon")
	public List<Coupon> getCoupons(){
		
		return iCouponService.getCoupon();
	}
	
	@GetMapping("/getcouponbyuser/{uid}")
	public Coupon getByuser(@PathVariable("uid") Long uid) {
		return iCouponService.getByuser(uid);
	}
	
	@DeleteMapping("deletecouponbyuser/{userId}")
	public void deleteByUser(@PathVariable("userId") Long userId) {
		iCouponService.deleteByuser(userId);
	}
	
	
	
	
	
	
	
	
	
	
	
}
