package fr.humanbooster.sparks.avis.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import fr.humanbooster.sparks.avis.business.Classification;
import fr.humanbooster.sparks.avis.business.Editeur;
import fr.humanbooster.sparks.avis.business.Genre;
import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.business.ModeleEconomique;
import fr.humanbooster.sparks.avis.business.Moderateur;
import fr.humanbooster.sparks.avis.business.Plateforme;
import fr.humanbooster.sparks.avis.dao.ClassificationDao;
import fr.humanbooster.sparks.avis.dao.EditeurDao;
import fr.humanbooster.sparks.avis.dao.GenreDao;
import fr.humanbooster.sparks.avis.dao.JeuDao;
import fr.humanbooster.sparks.avis.dao.JoueurDao;
import fr.humanbooster.sparks.avis.dao.ModeleEconomiqueDao;
import fr.humanbooster.sparks.avis.dao.ModerateurDao;
import fr.humanbooster.sparks.avis.dao.PlateformeDao;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InitController implements CommandLineRunner {

	private final EditeurDao editeurDao;
	private final GenreDao genreDao;
	private final ClassificationDao classificationDao;
	private final PlateformeDao plateformeDao;
	private final ModeleEconomiqueDao modeleEconomiqueDao;
	private final JoueurDao joueurDao;
	private final ModerateurDao moderateurDao;
	private final JeuDao jeuDao;
	private static final Faker faker = new Faker(new Locale("fr-FR"));

	// private final HttpSession httpSession;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("test");
		ajouterGenres();
		ajouterEditeurs();
		ajouterClassifications();
		ajouterPlateformes();
		ajouterModeleEconomiques();
		ajouterJoueurs();
		ajouterModerateurs();
		// ajouterJeux();
		ajouterJeuxAleatoires();
	}

	private void ajouterJeuxAleatoires() {
		if (jeuDao.count() == 0) {

			for (int i = 0; i < 5; i++) {
				Jeu jeu = new Jeu();
				jeu.setNom(faker.name().lastName());
				jeu.setDescription(faker.lorem().paragraph(2));
				jeu.setDateSortie(LocalDate.now());
				jeu.setImage("/chemin/image");
				jeu.setGenre(genreDao.findById(1L).orElse(null));
				jeu.setEditeur(editeurDao.findById(1L).orElse(null));
				jeu.setClassification(classificationDao.findById(1L).orElse(null));

				ArrayList<Plateforme> plateformes = new ArrayList<>();
				plateformes.add(plateformeDao.findById(1L).orElse(null));
				plateformes.add(plateformeDao.findById(2L).orElse(null));
				jeu.setPlateformes(plateformes);
				// jeuDao.save(jeu);
				jeu.setModeleEconomique(modeleEconomiqueDao.findById(1L).orElse(null));
				jeu.setModerateur(null);

				jeuDao.save(jeu);
			}
		}
	}

	private void ajouterJeux() {
		if (jeuDao.count() == 0) {
			// Jeu jeu = new Jeu("Rayman", "/chemin/image");
			Jeu jeu = new Jeu();
			jeu.setNom("Rayman");
			jeu.setDescription("Description");
			jeu.setDateSortie(LocalDate.now());
			jeu.setImage("/chemin/image");
			jeu.setGenre(genreDao.findById(1L).orElse(null));
			jeu.setEditeur(editeurDao.findById(1L).orElse(null));
			jeu.setClassification(classificationDao.findById(1L).orElse(null));

			ArrayList<Plateforme> plateformes = new ArrayList<>();
			plateformes.add(plateformeDao.findById(1L).orElse(null));
			plateformes.add(plateformeDao.findById(2L).orElse(null));
			jeu.setPlateformes(plateformes);
			// jeuDao.save(jeu);
			jeu.setModeleEconomique(modeleEconomiqueDao.findById(1L).orElse(null));
			jeu.setModerateur(null);

			jeuDao.save(jeu);
		}
	}

	private void ajouterModerateurs() {
		if (moderateurDao.count() == 0) {
			moderateurDao.save(new Moderateur("janno", "123", "janno@hb.com", "0475079874"));
			moderateurDao.save(new Moderateur("fifi", "123", "fifi@hb.com", "0475741200"));
		}
	}

	private void ajouterJoueurs() {
		if (joueurDao.count() == 0) {
			joueurDao.save(new Joueur("nefer", "123", "nefer@hb.com", LocalDate.of(1974, 8, 29)));
			joueurDao.save(new Joueur("ramses", "123", "ramses@hb.com", LocalDate.of(2005, 6, 17)));
		}
	}

	private void ajouterModeleEconomiques() {
		if (modeleEconomiqueDao.count() == 0) {
			modeleEconomiqueDao.save(new ModeleEconomique("free to play"));
			modeleEconomiqueDao.save(new ModeleEconomique("pay to play"));
		}
	}

	private void ajouterPlateformes() {
		if (plateformeDao.count() == 0) {
			plateformeDao.save(new Plateforme("Switch"));
			plateformeDao.save(new Plateforme("PS5"));
		}
	}

	private void ajouterClassifications() {
		if (classificationDao.count() == 0) {
			classificationDao.save(new Classification("PEGI 3"));
			classificationDao.save(new Classification("PEGI 7"));
			classificationDao.save(new Classification("PEGI 12"));
			classificationDao.save(new Classification("PEGI 16"));
			classificationDao.save(new Classification("PEGI 18"));
		}
	}

	private void ajouterEditeurs() {
		if (editeurDao.count() == 0) {
			editeurDao.save(new Editeur("Ubisoft"));
			editeurDao.save(new Editeur("Electronic Arts"));
		}
	}

	private void ajouterGenres() {
		if (genreDao.count() == 0) {
			genreDao.save(new Genre("Aventure"));
			genreDao.save(new Genre("Course"));
		}
	}

}
