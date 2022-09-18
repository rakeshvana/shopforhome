package com.capstone.shopforhome.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capstone.shopforhome.dto.OrderDTO;
import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.entity.User;

/*
 * @Author:Dynaeshwari
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

public interface IOrderService {
	
	public String addOrder(ArrayList<CartItem> orderItems);
	public List<Orders> getOrdersByProduct(Product prod);
	public List<Orders> getOrder();
	public List<Orders> getByDate(String from,String to);
	public List<Orders> getByDateAndProduct(String from,String to,Long pid);
}
