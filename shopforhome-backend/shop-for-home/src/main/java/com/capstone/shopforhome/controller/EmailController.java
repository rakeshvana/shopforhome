package com.capstone.shopforhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.service.IEmailService;

/*
 * @Author:Vignesh
 * Modified Date:30-08-2022
 * Description:This Controller class is responsible for processing incoming REST API request.
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmailController {
	
	@Autowired
	IEmailService iemailService;

	@GetMapping("/sendemail/{pid}")
	public String sendEmail(@PathVariable("pid") Long pid) {
		return iemailService.sendEmail(pid);
		 
	}
}
