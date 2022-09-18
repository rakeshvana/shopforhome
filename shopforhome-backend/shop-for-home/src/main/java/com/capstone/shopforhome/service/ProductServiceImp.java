package com.capstone.shopforhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.dto.ProductDTO;
import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.repository.ProductRepository;
import com.capstone.shopforhome.service.IProductService;

/*
 * @Author:vignesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class ProductServiceImp implements IProductService{
	
	@Autowired
	private ProductRepository repo;
	
	
	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for adding the product
	 * params : ProductDTO
	 * return type : Product
	 */
	@Override
	public Product addProduct(ProductDTO dto) {
		Product product = new Product();
		product.setPid(dto.getPid());
		product.setProductName(dto.getProductName());
		product.setProductCategory(dto.getProductCategory());
		product.setProductDescription(dto.getProductDescription());
		product.setProductStock(dto.getProductStock());
		product.setProductPrice(dto.getProductPrice());
		product.setProductImage(dto.getProductImage());
		return repo.save(product);
	}

	
	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for deleting the product 
	 * params : Long Pid 
	 * return type : void
	 */
	@Override
	public void deleteProduct(Long pid) {
		repo.deleteById(pid);

	}

	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for updating the product
	 * params : ProductDTO dto , Long pid
	 * return type : Product
	 */
	
	@Override
	public Product updateProduct(ProductDTO dto, Long pid) {
		Product product = repo.findById(pid).get();
		product.setProductName(dto.getProductName());
		product.setProductCategory(dto.getProductCategory());
		product.setProductDescription(dto.getProductDescription());
		product.setProductStock(dto.getProductStock());
		product.setProductPrice(dto.getProductPrice());
		product.setProductImage(dto.getProductImage());
		return repo.save(product);
	}
	
	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting all the product
	 * params : none
	 * return type : List<Product>
	 */
	@Override
	public List<Product> getProduct() {
		return repo.findAll();
	}
	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting the product by id
	 * params : Long pid
	 * return type : Product
	 */
	
	@Override
	public Product getProductById(Long pid) {
		// TODO Auto-generated method stub
		return repo.getById(pid);
	}

	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for listing all the ids of products
	 * params : none
	 * return type : List<Long>
	 */
	
	public List<Long> getAllIds(){
		return repo.getAllIds();
	}
}
