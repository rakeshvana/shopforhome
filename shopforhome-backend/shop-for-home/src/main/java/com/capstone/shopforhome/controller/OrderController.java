package com.capstone.shopforhome.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.dto.OrderDTO;
import com.capstone.shopforhome.entity.CartItem;
import com.capstone.shopforhome.entity.Orders;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.service.IOrderService;
import com.capstone.shopforhome.service.IProductService;


/*
 * @Author:Dyaneshwari
 * Modified Date:29-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private IOrderService iOrderService;
	
	@Autowired
	private IProductService productService;
	
	@PostMapping("order/{userId}/addorder")
	public String addOrders(@PathVariable("userId") Long userId, @RequestBody ArrayList<CartItem> orderItems) {
		return iOrderService.addOrder(orderItems);
	}
	
	
	@GetMapping("/getallorder")
	public List<Orders> getOrders(){
		
		return iOrderService.getOrder();
	}
	
	
	@GetMapping("/getordersbyprod/{productId}")
	public List<Orders> getOrdersByProduct(@PathVariable("productId") Long productId){
		Product prod = productService.getProductById(productId);
		
		
		return iOrderService.getOrdersByProduct(prod);
	}
	
	//get the sales report of a specific duration
	@GetMapping("/getreportbydate/{from}/{to}")
	public List<Orders> getSalesReportByDate(@PathVariable String from,@PathVariable String to){
		
		return iOrderService.getByDate(from, to);
	}
	
	@GetMapping("/getreportbydateandprod/{from}/{to}/{pid}")
	public List<Orders> getSalesReportByDate(@PathVariable String from,@PathVariable String to,@PathVariable("pid") Long pid){
		
		return iOrderService.getByDateAndProduct(from, to,pid);
	}
	
	
	
	
	
	
	
	
}
