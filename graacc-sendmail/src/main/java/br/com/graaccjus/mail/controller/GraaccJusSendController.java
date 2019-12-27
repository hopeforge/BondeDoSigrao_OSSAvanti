package br.com.graaccjus.mail.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.graaccjus.mail.entity.GraaccEmailEntity;
import br.com.graaccjus.mail.exceptions.SenderMailException;

@RestController
//@RequestMapping("/send")
public class GraaccJusSendController {
	
	@Autowired(required= true)
	public JavaMailSender javaMailSender;
	
	private static final Logger logger = LogManager.getLogger(GraaccJusSendController.class);
	@CrossOrigin
	@PostMapping("/send")
	public void sendEmail(@RequestBody GraaccEmailEntity graaccEmailEntity) {
		
		logger.info("Intialize method sendEmail");
		try {

		validateRequest(graaccEmailEntity);
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(graaccEmailEntity.getListEmail().toArray(new String[0]));
		message.setSubject(graaccEmailEntity.getsubjectEmail());
		message.setText(graaccEmailEntity.getbodyEmail());
		
		javaMailSender.send(message);
		
		} catch(MailException e) {
				logger.error("Not possible send to email", e);
				e.printStackTrace();			
		}
		logger.info("Finalize method sendEmail");
	}
	@CrossOrigin
	@PostMapping("/send-html")
	public void sendEmailHTML(@RequestBody GraaccEmailEntity graaccEmailEntity) throws MessagingException {
		
		logger.info("Intialize method sendEmailHTML");
		try {

		validateRequest(graaccEmailEntity);
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		
		helper.setTo(graaccEmailEntity.getListEmail().toArray(new String[0]));
		helper.setSubject(graaccEmailEntity.getsubjectEmail());
		helper.setText(graaccEmailEntity.getbodyEmail(), true);
		
		javaMailSender.send(message);
		
		} catch(MailException e) {
				logger.error("Not possible send to email", e);
				e.printStackTrace();			
		}
		logger.info("Finalize method sendEmailHTML");
	}

	private void validateRequest(GraaccEmailEntity graaccEmailEntity) {
		if(null == graaccEmailEntity) {
			throw new SenderMailException();
		}
		if(null == graaccEmailEntity.getListEmail()) {
			throw new SenderMailException();
		}
	}
}