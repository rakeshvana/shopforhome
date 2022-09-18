package com.capstone.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.discount.entity.Coupon;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This class is responsible for communicating the database
 * 
 */

@Repository
public interface CouponRepo extends JpaRepository<Coupon,Long> {
	
	
	//@Query(value="SELECT * FROM coupon  WHERE coupon.user_id = ?1",nativeQuery=true)
	 Coupon findByUserId(Long user);
	
	
	
	
	//@Query(value="DELETE FROM coupon c WHERE c.user_id = ?1",nativeQuery=true)
	void deleteByUserId(Long user);

}
