package fr.humanbooster.sparks.avis.service;

import java.util.List;

import fr.humanbooster.sparks.avis.business.Avis;

public interface AvisService {

	List<Avis> recupererAvis();
	
	Avis ajouterAvis(Avis avis);

	Avis ajouterAvis(Long idJeu, String description, Float note);

	

}
