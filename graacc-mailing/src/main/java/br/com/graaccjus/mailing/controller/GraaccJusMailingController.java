package br.com.graaccjus.mailing.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.graaccjus.mailing.entity.MailingEntity;
import br.com.graaccjus.mailing.repository.MailingRepository;

@RestController
public class GraaccJusMailingController {

	@Autowired(required = true)
	public MailingRepository mailingRepository;

	private static final Logger logger = LogManager.getLogger(GraaccJusMailingController.class);
	@CrossOrigin
	@PostMapping("/mailing")
	public ResponseEntity<String> saveMailing(@RequestBody MailingEntity mailingEntity) {

		logger.info("Intialize method saveMailing");
		try {
			mailingRepository.save(mailingEntity);
		} catch (Exception e) {
			return new ResponseEntity<>("Ocorreu algum erro ao salvar os dados.", HttpStatus.BAD_REQUEST);
		}
		logger.info("Finalize method sendEmail");
		return new ResponseEntity<>("Dados inseridos com sucesso", HttpStatus.CREATED);
	}
	@CrossOrigin
	@GetMapping()
	public List<MailingEntity> findMailings() {

		logger.info("Intialize method findMailings");
		
		Iterable<MailingEntity> mailingEntity = mailingRepository.findAll();
			
		logger.info("Finalize method findMailings");
		return (List<MailingEntity>) mailingEntity;
	}
}