package com.capstone.discount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.discount.dto.CouponDTO;
import com.capstone.discount.entity.Coupon;
import com.capstone.discount.repository.CouponRepo;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This class is a responsible for assiging the discount coupons to the users
 * 
 */

@Service
public class CouponServiceImpl implements ICouponService {

	@Autowired
	private CouponRepo repo;
	
	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This method is used for adding the coupon
	 * params:CouponDTO dto 
	 * return : Coupon
	 * 
	 */
	
	@Override
	public Coupon addCoupon(CouponDTO dto) {
		Coupon coupon = new Coupon();
		coupon.setCouponName(dto.getCouponName());
		coupon.setPercentage(dto.getPercentage());
		coupon.setUserId(dto.getUserId());
		
		Coupon user = repo.findByUserId(dto.getUserId());
		
		if(user!=null) {
			user.setCouponName(dto.getCouponName());
			user.setPercentage(dto.getPercentage());
			user.setUserId(dto.getUserId());
			return repo.save(user);
		}
		return repo.save(coupon);
	}
	
	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This class is used for deleting the coupons
	 * params:Long couponId
	 * return : void
	 * 
	 */
	
	@Override
	public void deleteCoupon(Long couponId) {
		repo.deleteById(couponId);
		
	}

	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This class is used for updating  the coupons
	 * params:CouponDTO dto, Long couponId
	 * return : Coupon
	 * 
	 */
	
	@Override
	public Coupon updateCoupon(CouponDTO dto, Long couponId) {
		Coupon coupon = repo.findById(couponId).get();
		coupon.setCouponName(dto.getCouponName());
		coupon.setPercentage(dto.getPercentage());
		coupon.setUserId(dto.getUserId());
		return repo.save(coupon);
	}

	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This class is used for getting the coupons
	 * params:none
	 * return : List<Coupon>
	 * 
	 */
	
	@Override
	public List<Coupon> getCoupon() {
		return repo.findAll();
	}
	
	
	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This class is used for getting coupons of a specifed user
	 * params:Long userId
	 * return : Coupon
	 * 
	 */
	@Override
	public Coupon getByuser(Long userId) {
		return repo.findByUserId(userId);
	}
	
	/*
	 * @Author:
	 * Modified Date:30-08-2022
	 * Description:This class is used for deleting coupons of specified user
	 * params:Long userId
	 * return : void
	 * 
	 */
	@Override
	public void deleteByuser(Long userId) {
		repo.deleteByUserId(userId);
	}

	

	
}
