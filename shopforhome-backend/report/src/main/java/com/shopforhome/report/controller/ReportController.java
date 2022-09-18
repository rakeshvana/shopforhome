package com.shopforhome.report.controller;
/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This controller class is for processing the incomming the rest api reqests
 * 
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopforhome.report.entity.Report;
import com.shopforhome.report.helpers.Orders;
import com.shopforhome.report.helpers.Product;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	
	
	
	
	//@GetMapping("report/get")
	public List<Orders> getAllOrderByProductId(Long id) {
		 Orders[] products = restTemplate.getForObject("http://localhost:8181/getordersbyprod/"+id, Orders[].class);
		    List<Orders> prod= Arrays.asList(products);
		   return prod;
		
	}
	//@GetMapping("report/getbydate")
	public List<Orders> getProductsByDate(String from ,String to,Long pid) {
		
		 Orders[] products = restTemplate.getForObject("http://localhost:8181/getreportbydateandprod/"+from+"/"+to+"/"+pid, Orders[].class);
		    List<Orders> prod= Arrays.asList(products);
		    return prod;
		
	}
	
	
	//@GetMapping("prodbyid/{pathid}")
	public ResponseEntity<Product> getProductById( Long pid) {
		return restTemplate.getForEntity("http://localhost:8181/getproductbyid/"+pid, Product.class);
	}
	
	
	

	public List<Long> getAllProductIDs(){
		//return restTemplate.getForEntity("http://localhost:8181/getallids",Long[].class);
		
		 Long[] res = restTemplate.getForObject("http://localhost:8181/getallids", Long[].class);
		    List<Long> ids= Arrays.asList(res);
		    return ids;
		
	}
	
	
	
	
	
	
	@GetMapping("/report")
	public List<Report> getProductsReport(){
		List<Report> report = new ArrayList<Report>();
		List<Long> ids = getAllProductIDs();
		
		//List<ResponseEntity<Long[]>> ids = Arrays.asList(a);
		for(Long id : ids) {
			Long orderedAmount = (long) 0;
			double profit=0;
			Report obj = new Report();
			List<Orders> products=getAllOrderByProductId(id);
			for(Orders order:products) {
				if(products.isEmpty()) {
					System.out.println("333333"+products);
					ResponseEntity<Product> product = getProductById(id);
					System.out.println(product);
					obj.setProductId(product.getBody().getPid());
					obj.setProductName(product.getBody().getProductImage());
					obj.setCurrentStock(product.getBody().getProductStock());
					obj.setProductCategory(product.getBody().getProductCategory());
					obj.setPrice(product.getBody().getProductPrice());
					obj.setOrderedAmount((long) 0);
					obj.setProfit(0);
				}
				else {
				
				obj.setProductId(order.getProduct().getPid());
				obj.setProductName(order.getProduct().getProductName());
				obj.setCurrentStock(order.getProduct().getProductStock());
				obj.setProductCategory(order.getProduct().getProductCategory());
				obj.setPrice(order.getProduct().getProductPrice());
				obj.setProductImage(order.getProduct().getProductImage());
				orderedAmount+=order.getQuantity();
			
				profit=profit+order.getPrice();	
				obj.setOrderedAmount(orderedAmount);
				obj.setProfit(orderedAmount*order.getPrice());
				}
			}
			report.add(obj);
		}
		return report;
		
	}
	
	@GetMapping("/report/{from}/{to}")
	public List<Report> getProductsReport(@PathVariable("from") String from,@PathVariable("to") String to){
		List<Report> report = new ArrayList<Report>();
		List<Long> ids = getAllProductIDs();
		
		for(Long id : ids) {
			Long orderedAmount = (long) 0;
			double profit=0;
			Report obj = new Report();
			List<Orders> products=getProductsByDate(from,to,id);
			for(Orders order:products) {
				if(products.isEmpty()) {
					System.out.println("333333"+products);
					ResponseEntity<Product> product = getProductById(id);
					System.out.println(product);
					obj.setProductId(product.getBody().getPid());
					obj.setProductName(product.getBody().getProductImage());
					obj.setCurrentStock(product.getBody().getProductStock());
					obj.setProductCategory(product.getBody().getProductCategory());
					obj.setPrice(product.getBody().getProductPrice());
					
					obj.setOrderedAmount((long) 0);
					obj.setProfit(0);
				}
				else {
				
				obj.setProductId(order.getProduct().getPid());
				obj.setProductName(order.getProduct().getProductName());
				obj.setCurrentStock(order.getProduct().getProductStock());
				obj.setProductCategory(order.getProduct().getProductCategory());
				obj.setPrice(order.getProduct().getProductPrice());
				obj.setProductImage(order.getProduct().getProductImage());
				orderedAmount+=order.getQuantity();
			
				profit=profit+order.getPrice();	
				obj.setOrderedAmount(orderedAmount);
				obj.setProfit(orderedAmount*order.getPrice());
				}
			}
			report.add(obj);
		}
		return report;
		
	}
	

}
