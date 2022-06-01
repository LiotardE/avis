package fr.humanbooster.sparks.avis.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.dao.AvisDao;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvisServiceImpl implements AvisService {
	
	private final AvisDao avisDao;
	private final JeuService jeuService;

	@Override
	public List<Avis> recupererAvis() {		
		return avisDao.findAll();
	}

	@Override
	public Avis ajouterAvis(Avis avis) {		
		return avisDao.save(avis);
	}

	@Override
	public Avis ajouterAvis(Long idJeu, String description, Float note) { 
		Avis avis = new Avis();
		avis.setJeu(jeuService.recupererJeu(idJeu));
		avis.setDescription(description);
		avis.setNote(note);
		avis.setDateEnvoi(LocalDateTime.now());
		return avisDao.save(avis);
	}

}
