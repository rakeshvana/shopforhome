package com.capstone.shopforhome.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.entity.Wishlist;

/*
 * @Author:vignesh
 * Modified Date:30-08-2022
 * Description:This Repository class is responsible for communicating with the database.
 */



@Repository
public interface WishlistRepository extends JpaRepository<Wishlist,Long>{
	
	public List<Wishlist> findByUser(User user);
	public Wishlist findByUserAndProduct(User user, Product product);
}
