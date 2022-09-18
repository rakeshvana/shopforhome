package com.capstone.shopforhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.capstone.shopforhome.entity.Product;
import com.capstone.shopforhome.repository.ProductRepository;
	
/*
 * @Author:vignesh
 * Modified Date:30-08-2022
 * Description:This service class is peroforming the business logic.
 */

@Service
public class EmailServiceImp implements IEmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	ProductRepository repo;
	
	
	/*
	 * @Author:vignesh
	 * Modified Date:30-08-2022
	 * Description:This service method used for sending the mail
	 * params : Long pid
	 * return type : String
	 */
	
	@Override
	public String sendEmail(Long pid) {
		
		Product prod = repo.findById(pid).orElse(new Product());
		
        SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("capstoneaug@gmail.com");
		message.setTo("rakesh876@gmail.com");
		message.setSubject(prod.getProductName()+" Stock is Less");
		message.setText("Respected Sir the Stock for our product "+prod.getProductName()+" which under the category "+prod.getProductCategory()+ "is "+prod.getProductStock()+" Please make arrangements soon before we run out of stock");
		
		javaMailSender.send(message);
		
		return "Mail sent successfully";
	}


}
