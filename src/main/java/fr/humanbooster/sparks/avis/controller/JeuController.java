package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.business.ModeleEconomique;
import fr.humanbooster.sparks.avis.service.ClassificationService;
import fr.humanbooster.sparks.avis.service.EditeurService;
import fr.humanbooster.sparks.avis.service.GenreService;
import fr.humanbooster.sparks.avis.service.JeuService;
import fr.humanbooster.sparks.avis.service.ModeleEconomiqueService;
import fr.humanbooster.sparks.avis.service.PlateformeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class JeuController {
	
	// Attributs (toujours au début de la classe)
		// (quelles sont les dépendances ?)	
		private final HttpSession httpSession;
		
		private final JeuService jeuService;
		private final EditeurService editeurService;
		private final GenreService genreService;
		private final ClassificationService classificationService;
		private final PlateformeService plateformeService;
		private final ModeleEconomiqueService modeleEconomiqueService;

		// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
		// ModelAndView
		// (métaphore de la Danette Pop)
		// On indique sur quelle(s) URL(s) la méthode va écouter
		// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
		// Equivalent de @WebServlet
		@GetMapping(value = "/jeux")
		public ModelAndView jeuGet() {
			// On déclare et on instancie un objet de type ModelAndView
			ModelAndView mav = new ModelAndView();
			// On définit le nom de la vue (== crème dessert)
			// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
			mav.setViewName("jeux");
			// Récupérer les avis dans la base de données
			mav.addObject("jeux", jeuService.recupererJeux());
			// Renvoyer la vue
			return mav;
		}
		
		// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
		// ModelAndView
		// (métaphore de la Danette Pop)
		// On indique sur quelle(s) URL(s) la méthode va écouter
		// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
		// Equivalent de @WebServlet
		@GetMapping(value = "/jeux/ajouter-un-jeu")
		public ModelAndView jeuAjouterGet(Jeu jeu) {
			// On déclare et on instancie un objet de type ModelAndView
			ModelAndView mav = new ModelAndView();
			// On définit le nom de la vue (== crème dessert)
			// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
			mav.setViewName("ajouterUnJeu");
			mav.addObject("editeurs", editeurService.recupererEditeurs());
			mav.addObject("genres", genreService.recupererGenres());
			mav.addObject("classifications", classificationService.recupererClassifications());
			mav.addObject("plateformes", plateformeService.recupererPlateformes());
			mav.addObject("modeleEconomiques", modeleEconomiqueService.recupererModeleEcomoniques());
			return mav;
		}
		
		@PostMapping("/jeux/ajouter-un-jeu")
		public ModelAndView jeuAjouterPost(@Valid @ModelAttribute("jeu") Jeu jeu, BindingResult result) {
			if (result.hasErrors()) {
				// La validation de l’objet utilisateur par rapport aux contraintes
				// de validation définies dans la classe métier Utilisateur a produit
				// des erreurs
				ModelAndView mav = jeuAjouterGet(jeu);
				mav.addObject("jeux", jeuService.ajouterJeu(jeu));
				return mav;
			} else {
				jeuService.ajouterJeu(jeu);
				return new ModelAndView("redirect:/index");
			}
		}
		//mav.addObject("jeux", jeuService.ajouterJeu());

}
