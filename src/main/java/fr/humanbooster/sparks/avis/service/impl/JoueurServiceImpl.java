package fr.humanbooster.sparks.avis.service.impl;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.dao.JoueurDao;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JoueurServiceImpl implements JoueurService {
	
	// Attributs de la classe de service (== ses dépendances)
	private JoueurDao joueurDao;

	@Override
	public Joueur recupererJoueur(String pseudo, String motDePasse) {		
		return joueurDao.findByPseudo(pseudo);
	}

}
