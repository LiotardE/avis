package fr.humanbooster.sparks.avis.business;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  // classe abstraite
@DiscriminatorColumn(name="TypeUtilisateur")
public abstract class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

	@NotBlank(message = "L'utilisateur doit avoir un pseudo")
    protected String pseudo;

	@NotBlank(message = "L'utilisateur doit avoir un mot de passe")
    protected String motDePasse;

	@NotBlank(message = "L'utilisateur doit avoir un email")
	@Email
	@Column(unique = true, nullable = false, length = 150)
    protected String email;

}