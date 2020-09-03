package com.kaibal.tech.springbootbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.kaibal.tech.springbootbackend.exception.ResourceNotFoundException;
import com.kaibal.tech.springbootbackend.model.Email;
import com.kaibal.tech.springbootbackend.repository.EmailRepository;

@Service
public class EmailSenderService {

	@Autowired
	EmailRepository emailRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	static final String MYEMAILADDRESS = "kervinbalibagoso@gmail.com";

	public ResponseEntity<Email> processEmail(Email email) {
		Optional.ofNullable(email).ifPresentOrElse(e -> sendEmail(e),
				() -> new ResourceNotFoundException("Nothing to send!"));
		emailRepository.save(email);
		return ResponseEntity.ok(email);
	}

	public void sendEmail(Email email) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setFrom(email.getEmailAddress());
		simpleMessage.setTo(MYEMAILADDRESS);
		simpleMessage.setSubject(email.getSubject());
		simpleMessage.setText(email.getName().concat(" : ").concat(email.getMessage()));
		javaMailSender.send(simpleMessage);

	}

}
