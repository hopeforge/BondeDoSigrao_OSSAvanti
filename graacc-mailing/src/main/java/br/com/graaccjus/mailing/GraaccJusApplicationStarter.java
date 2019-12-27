package br.com.graaccjus.mailing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraaccJusApplicationStarter {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("server.servlet.context-path", "/app/api");
		SpringApplication.run(GraaccJusApplicationStarter.class, args);
	}
}
