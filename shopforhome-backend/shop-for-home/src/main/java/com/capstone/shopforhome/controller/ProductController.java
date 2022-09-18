package com.capstone.shopforhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.dto.ProductDTO;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.service.IProductService;

/*
 * @Author:
 * Modified Date:30-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

		
		@Autowired
		private IProductService iProductService;
		
		@PostMapping("/addproduct")
		public Product addProducts(@RequestBody ProductDTO dto) {
			return iProductService.addProduct(dto);
		}
		
		@DeleteMapping("/deleteproduct/{pid}")
		public String deleteProducts(@PathVariable Long pid) {
			iProductService.deleteProduct(pid);
			return "Deleted Successfully";
		}
		
		@PutMapping("/updateproduct/{pid}")
		public Product updateProducts(@RequestBody ProductDTO dto,@PathVariable Long pid ) {
			return iProductService.updateProduct(dto, pid);
		}
		
		@GetMapping("/getproduct")
		public List<Product> getProducts(){
			
			return iProductService.getProduct();
		}
		
		@GetMapping("/getallids")
		public List<Long> getAllIds(){
			return iProductService.getAllIds();
			}
		
		@GetMapping("/getproductbyid/{pid}")
		public Product getProdctById(@PathVariable("pid") Long pid) {
			
			
			return iProductService.getProductById(pid);
		}
		

	}

