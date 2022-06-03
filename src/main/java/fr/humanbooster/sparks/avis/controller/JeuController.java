package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	//private final HttpSession httpSession;

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
		@GetMapping(value = "/jeux/voir")
		public ModelAndView jeuDetailGet(@RequestParam("idJeu") Long id) {
			// On déclare et on instancie un objet de type ModelAndView
			ModelAndView mav = new ModelAndView();
			// On définit le nom de la vue (== crème dessert)
			// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
			mav.setViewName("voir");
			// Récupérer les avis dans la base de données
			mav.addObject("jeu", jeuService.recupererJeu(id));
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
			mav.addObject("jeu", jeuService.ajouterJeu(jeu));
			return mav;
		} else {
			jeuService.ajouterJeu(jeu);
			return new ModelAndView("redirect:/jeux");
		}
	}

	@GetMapping("/jeux/modifier-jeu")
	public ModelAndView modifierJeuGet(@RequestParam("idJeu") Long id) {
		// communique entre le modèle et la vue
		ModelAndView mav = new ModelAndView();
		// le nom de la vue
		mav.setViewName("modifierUnJeu");
		// le service du jeu me renvoie les informations du jeu par son identifiant
		Jeu jeu = jeuService.recupererJeu(id);
		mav.addObject(jeu);
		mav.addObject("editeurs", editeurService.recupererEditeurs());
		mav.addObject("genres", genreService.recupererGenres());
		mav.addObject("classifications", classificationService.recupererClassifications());
		mav.addObject("plateformes", plateformeService.recupererPlateformes());
		mav.addObject("modeleEconomiques", modeleEconomiqueService.recupererModeleEcomoniques());
		return mav;
	}
	

	@PostMapping("/jeux/modifier-un-jeu")
	public ModelAndView jeuModifierPost(@Valid @ModelAttribute("jeu") Jeu jeu, BindingResult result) {
		if (result.hasErrors()) {
			// La validation de l’objet utilisateur par rapport aux contraintes
			// de validation définies dans la classe métier Utilisateur a produit
			// des erreurs
			ModelAndView mav = jeuAjouterGet(jeu);
			mav.addObject("jeu", jeu);
			mav.setViewName("modifierUnJeu");
			return mav;
		} else {
			jeuService.modifierJeu(jeu);
			return new ModelAndView("redirect:/jeux");
		}
	}

	@RequestMapping(value = "jeux/delete-jeu", method = RequestMethod.GET)
	public ModelAndView deleteJeu(@RequestParam("idJeu") Long id) {
		jeuService.deleteJeu(id);
		// service.deleteJeu(id);
		return new ModelAndView("redirect:/jeux");
	}
}
