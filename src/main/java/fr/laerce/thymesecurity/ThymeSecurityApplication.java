package fr.laerce.thymesecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeSecurityApplication.class, args);

		// TODO : creer formulaire de modif des mots de passe
		// 3 champs : old, new, confirm new
		// le old ne s'affiche pas pour l'administrateur, qui logiquement, ne le connait pas
		// a part ça, il est acessible à tous
		// TODO : creer une liste d'utilisateurs
		// elle n'est acessible qu'à l'administrateur
	}
}
