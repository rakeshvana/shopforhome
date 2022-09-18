package com.capstone.shopforhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstone.shopforhome.entity.Product;

/*
 * @Author:Dyaneshwari
 * Modified Date:30-08-2022
 * Description:This Repository class is responsible for communicating with the database.
 */


@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
	
	@Query("select p.pid from Product p")
	List<Long> getAllIds();
	
	

}
