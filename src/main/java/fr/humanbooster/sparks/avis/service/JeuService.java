package fr.humanbooster.sparks.avis.service;

import java.util.List;

import javax.validation.Valid;

import fr.humanbooster.sparks.avis.business.Jeu;

public interface JeuService {

	List<Jeu> recupererJeux();

	Jeu recupererJeu(Long idJeu);

	Jeu ajouterJeu(Jeu jeu);

	void deleteJeu(Long id);

	void modifierJeu(@Valid Jeu jeu);

	
	

	



}
