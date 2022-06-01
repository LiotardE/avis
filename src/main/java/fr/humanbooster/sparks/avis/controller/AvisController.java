package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.business.Jeu;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.JeuService;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvisController {

	// Attributs (toujours au début de la classe)
	// (quelles sont les dépendances ?)
	private final JoueurService joueurService;
	private final HttpSession httpSession;
	private final AvisService avisService;
	private final JeuService jeuService;

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = "/avis")
	public ModelAndView avisGet() {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("avis");
		mav.addObject("avis", avisService.recupererAvis());
		return mav;
	}

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = "/avis/ajouter-un-avis")
	public ModelAndView avisAjouteGet() {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("ajouterUnAvis");
		mav.addObject("jeux", jeuService.recupererJeux());
		return mav;
	}

	@PostMapping("/avis/ajouter-un-avis")
	public ModelAndView ajouterAvisPost(@RequestParam("DESCRIPTION") String description,
			@RequestParam("NOTE") Float note, @RequestParam("JEU") Long idJeu) {
		Avis avis = avisService.ajouterAvis(idJeu, description, note);
		return new ModelAndView("redirect:/avis");
	}

//	@PostMapping("/avis/ajouter-un-avis")
//	public ModelAndView avisPost(@Valid @ModelAttribute("avis") Avis avis, 
//			BindingResult result) {
//		if (result.hasErrors()) {
//			// La validation de l’objet avis par rapport aux contraintes
//			// de validation définies dans la classe métier Avis a produit
//			// des erreurs
//			ModelAndView mav = avisGet();
//			mav.addObject("avis", avis);
//			return mav;
//		} else {
//			avisService.ajouterAvis(avis);
//			return new ModelAndView("redirect:avis");
//		}
//	}

}