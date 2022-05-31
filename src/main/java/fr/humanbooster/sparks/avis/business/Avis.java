package fr.humanbooster.sparks.avis.business;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@NotBlank
	@Size(min = 8, max = 255, message = "Un avis doit contenir au minimum 8 caractères")
	private String description;
	
	private LocalDateTime dateEnvoi;

	@Range(min = 0, max = 20, message = "Merci de préciser une note comprise entre 0 et 20")
	private Float note;

	
	private LocalDateTime dateModeration;

	@ManyToOne
	private Joueur joueur;

	@ManyToOne
	private Moderateur moderateur;

	@ManyToOne
	private Jeu jeu;

}