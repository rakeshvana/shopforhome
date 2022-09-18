package com.capstone.shopforhome.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
class EmailServiceImplTest {

	@Autowired
	JavaMailSender javaMailSender;
	
	@Test
	void testSendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("capstoneaug@gmail.com");
		message.setTo("a.vigneshvaran@gmail.com");
		message.setSubject(" Stock is Less");
		message.setText("Respected Sir the Stock for our product which under the category is Please make arrangements soon before we run out of stock");
		
		javaMailSender.send(message);
		
		assertEquals("Mail sent successfully", "Mail sent successfully");
	}

}
