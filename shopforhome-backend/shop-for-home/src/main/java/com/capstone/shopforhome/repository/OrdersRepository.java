package com.capstone.shopforhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.shopforhome.entity.Orders;

/*
 * @Author:Rakesh
 * Modified Date:30-08-2022
 * Description:This Repository class is responsible for communicating with the database.
 */



@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long>{

}
