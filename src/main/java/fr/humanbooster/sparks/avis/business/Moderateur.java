package fr.humanbooster.sparks.avis.business;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Moderateur extends Utilisateur {
	 
	@NotBlank(message = "Le numéro de téléphone doit être renseigné")
	@Pattern(regexp = "^(?:(?:\\+|00)33|0)\s*[1-9](?:[\s.-]*\\d{2}){4}$", message = "Le numéro de téléphone doit être valide ! ")
    private String numeroDeTelephone;
	
	public Moderateur(String pseudo, String motDePasse, String email, String numeroDeTelephone) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;		
		this.numeroDeTelephone = numeroDeTelephone;
		
	}

}