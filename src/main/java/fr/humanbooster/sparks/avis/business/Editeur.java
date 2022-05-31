package fr.humanbooster.sparks.avis.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Editeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "L'éditeur doit avoir un nom")
	private String nom;

	@OneToMany(mappedBy = "editeur")
	private List<Jeu> jeux;
	
	public Editeur(String nom) {
		this.nom = nom;
	}

}