package fr.humanbooster.sparks.avis.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
//@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Joueur extends Utilisateur {

	@Past(message = "Hein !? Attends tu te fou de moi ! Ce joueur n'est même pas encore né !")
	private LocalDate dateDeNaissance;

	@OneToMany(mappedBy = "joueur")
	private List<Avis> avis;
	
	public Joueur(String pseudo, String motDePasse, String email, LocalDate dateDeNaissance) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.email = email;
		this.dateDeNaissance = dateDeNaissance;		
	}

}