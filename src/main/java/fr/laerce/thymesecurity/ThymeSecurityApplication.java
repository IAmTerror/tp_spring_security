package fr.laerce.thymesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeSecurityApplication {

	public static void main(String[] args) {
		// TODO : faire joujou avec csrf pour passer les méthodes GET en méthodes POST
		SpringApplication.run(ThymeSecurityApplication.class, args);
	}
}
