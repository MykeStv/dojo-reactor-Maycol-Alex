package com.sofkau.dojoreactor;

import com.sofkau.dojoreactor.service.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DojoReactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DojoReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DojoReactorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Email email = new Email();

		//CORREOS NO REPETIDOS
		//email.getEmailsNoRepeated().subscribe(e -> log.info("Emails no repetido: " + e));
		//email.countEmailsRepeated().subscribe(e -> log.info("Cantidad de emails no repetidos: " + e));

		//CORREO QUE CONTIENEN DOMINIOS
		String domain = "gmail";
		email.getEmailsByDomain(domain).subscribe(e -> log.info("Emails con " + domain+ ": " + e));
	}
}
