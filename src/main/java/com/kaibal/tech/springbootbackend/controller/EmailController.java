package com.kaibal.tech.springbootbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaibal.tech.springbootbackend.model.Email;
import com.kaibal.tech.springbootbackend.service.EmailSenderService;

@RestController
@RequestMapping("/api/v1/")
public class EmailController {

	@Autowired
	EmailSenderService emailSenderService;

	@PostMapping("send")
	public ResponseEntity<Email> sendEmail(@RequestBody Email email) {
		return emailSenderService.processEmail(email);
	}

}
