package com.sofkau.dojoreactor;

import com.sofkau.dojoreactor.service.BadWord;
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

		//A. CORREOS NO REPETIDOS
		System.out.println("\n Ejercicio 1: A");
		email.getEmailsNoRepeated().subscribe(e -> log.info("Emails no repetido: " + e));
		email.countEmailsRepeated().subscribe(e -> log.info("Cantidad de emails no repetidos: " + e));

		//B. CORREO QUE CONTIENEN DOMINIOS
		System.out.println("\n Ejercicio 1: B");
		String domain = "gmail";
		email.getEmailsByDomain(domain).subscribe(e -> log.info("Emails con " + domain+ ": " + e));

		//C. CORREOS VALIDOS
		System.out.println("\n Ejercicio 1: C");
		email.getEmailsValids().subscribe(e -> log.info("Emails validados: " + e));

		//D. CUENTA LOS CORREOS
		System.out.println("\n Ejercicio 1: D");
		email.countEmails().subscribe(c -> log.info("Cantidad de emails: " + c));

		//E. CUENTA LOS CORREOS SEGUN DOMINIO
		System.out.println("\n Ejercicio 1: E");
		email.countEmailsByDomain("@gmail.com").subscribe(c -> log.info("Cantidad de emails gmail: " + c));
		email.countEmailsByDomain("@hotmail.com").subscribe(c -> log.info("Cantidad de emails hotmail: " + c));
		email.countEmailsByDomain("@outlook.com").subscribe(c -> log.info("Cantidad de emails outlook: " + c));
		email.countEmailsByDomain("@sofka.com").subscribe(c -> log.info("Cantidad de emails sofka: " + c));

		//EJERCICIO 2
		System.out.println("\n Ejercicio 2: ");
		String frase = "Hola, su merced es una puta de verdad. Tambien, es una mierda de persona, pero lo quiero marica";
		BadWord badWord = new BadWord();
		badWord.correctorWords(frase).subscribe(w -> log.info(w.toString()));
	}
}
