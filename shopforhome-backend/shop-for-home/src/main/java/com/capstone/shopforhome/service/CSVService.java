package com.capstone.shopforhome.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.helper.CSVHelper;
import com.capstone.shopforhome.repository.ProductRepository;


/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class CSVService {
	
	@Autowired
	ProductRepository repo;
	
	/*
	 * @Author:Vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for getting the file from local storage 
	 * params : MultipartFile file 
	 * 
	 */
	
	
	  public void save(MultipartFile file) {
	    try {
	      List<Product> products = CSVHelper.csvToTutorials(file.getInputStream());
	      repo.saveAll(products);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }

}
