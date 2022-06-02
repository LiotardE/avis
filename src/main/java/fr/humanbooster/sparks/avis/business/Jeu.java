package fr.humanbooster.sparks.avis.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Jeu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Le jeu doit avoir un nom")
	@Column(unique = true, length = 32)
	private String nom;

	@Size(min = 8, max = 255, message = "Un avis doit contenir au minimum 8 caractères")
	private String description;

	private LocalDate dateSortie;

	@NotBlank(message = "Le jeu doit avoir au moins une capture")
	private String image;

	@ToStringExclude
	@ManyToOne
	private Classification classification;

	@ToStringExclude
	@ManyToOne
	private Genre genre;

	@ToStringExclude
	@ManyToOne
	private Editeur editeur;

	@ToStringExclude
	@ManyToMany
    //@ManyToMany(cascade = CascadeType.ALL)
    //@JoinTable(name = "jeu_plateforme", joinColumns = @JoinColumn(name = "plateforme_id"), inverseJoinColumns = @JoinColumn(name = "jeu_id"))
	private List<Plateforme> plateformes;

	@ToStringExclude
	@ManyToOne
	private ModeleEconomique modeleEconomique;
	
	@ManyToOne
	private Moderateur moderateur;

	@ToStringExclude
	@OneToMany(mappedBy = "jeu", fetch = FetchType.EAGER)
	private List<Avis> avis;
	
	public Jeu(String nom, String image) {
		this.nom = nom;
		this.image = image;
	}


}