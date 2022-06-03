package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.dao.JeuDao;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JeuServiceImpl implements JeuService {
	
	// Attributs de la classe de service (== ses dépendances)
	private JeuDao jeuDao;

	@Override
	public List<Jeu> recupererJeux() {		
		return jeuDao.findAll();
	}

	@Override
	public Jeu recupererJeu(Long idJeu) {
		return jeuDao.findById(idJeu).orElse(null);
	}

	@Override
	public Jeu ajouterJeu(Jeu jeu) {
		return jeuDao.save(jeu);
	}

	@Override
	public void deleteJeu(Long id) {		
		jeuDao.deleteById(id);
	}

	@Override
	public void modifierJeu(@Valid Jeu jeu) {
		jeuDao.save(jeu);		
	}

	


	
	
	
}
