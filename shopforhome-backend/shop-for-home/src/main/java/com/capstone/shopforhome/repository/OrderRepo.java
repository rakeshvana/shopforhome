package com.capstone.shopforhome.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;

/*
 * @Author:Amit
 * Modified Date:30-08-2022
 * Description:This Repository class is responsible for communicating with the database.
 */


@Repository
public interface OrderRepo extends JpaRepository<Orders, Long> {
	
	public List<Orders> findByProduct(Product prod);
	public List<Orders> findByOrderDateBetween(LocalDate from,LocalDate to);
	
	
	@Query(value="SELECT * FROM orders o WHERE o.order_date BETWEEN ?1 AND ?2 AND o.product_id= ?3",
			nativeQuery = true)
	public List<Orders> findByOrderDateBetweenAndProducts(LocalDate from,LocalDate to,Long pid);
	
}
