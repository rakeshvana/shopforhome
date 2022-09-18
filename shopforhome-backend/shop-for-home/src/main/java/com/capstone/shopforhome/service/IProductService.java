package com.capstone.shopforhome.service;

import java.util.List;

import com.capstone.shopforhome.dto.ProductDTO;
import com.capstone.shopforhome.entity.Product;
/*
 * @Author:Chaitanya
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

public interface IProductService {
	public Product addProduct(ProductDTO dto);
	public void deleteProduct(Long pid);
	public Product updateProduct(ProductDTO dto,Long pid);
	public List<Product> getProduct();
	public Product getProductById(Long pid);
	public List<Long> getAllIds();
}
