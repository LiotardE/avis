package fr.humanbooster.sparks.avis.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

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
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Le genre doit avoir un nom")
	private String nom;

	@ToStringExclude
	@OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
	private List<Jeu> jeux;

	public Genre(String nom) {
		this.nom = nom;
	}
}