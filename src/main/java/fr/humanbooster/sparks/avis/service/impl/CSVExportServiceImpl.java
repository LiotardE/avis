package fr.humanbooster.sparks.avis.service.impl;

import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.dao.AvisDao;
import fr.humanbooster.sparks.avis.service.CSVExportService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CSVExportServiceImpl implements CSVExportService {

	// Attributs de la classe de service (== ses dépendances)
	private AvisDao avisDao;

	@Override
	public void exportCSV(PrintWriter printWriter) {
		List<Avis> avis = avisDao.findAll();
		String[] entetes = { "Id", "Jeu", "Date envoi", "Date de modération", "Description", "Joueur", "Note" };
		try (CSVPrinter csvPrinter = new CSVPrinter(printWriter, CSVFormat.DEFAULT.withHeader(entetes))) {
			// : avis liste des avis 
			for (Avis avisItem : avis) {
				
				csvPrinter.printRecord(avisItem.getId(), 
						avisItem.getJeu().getNom(),
						DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(avisItem.getDateEnvoi()),
						//expression ? si vraie : si fausse.						
						(avisItem.getDateModeration() == null ? "non modéré" : DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(avisItem.getDateModeration())),
						
						avisItem.getDescription(),
						avisItem.getJoueur().getPseudo(),
						avisItem.getNote()
						);
			}
		} catch (Exception e) {
			System.out.println("Le fichier n'a pas pu être écrit.");
		}
	}

}
