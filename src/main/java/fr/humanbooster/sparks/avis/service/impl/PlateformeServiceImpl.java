package fr.humanbooster.sparks.avis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Plateforme;
import fr.humanbooster.sparks.avis.dao.PlateformeDao;
import fr.humanbooster.sparks.avis.service.PlateformeService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PlateformeServiceImpl implements PlateformeService {
	
	private final PlateformeDao plateformeDao;
	
	@Override
	public List<Plateforme> recupererPlateformes() {		
		return plateformeDao.findAll();
	}

}
