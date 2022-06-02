package fr.humanbooster.sparks.avis.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class InscriptionController {

	// Attributs (toujours au début de la classe)
	// (quelles sont les dépendances ?)
	private final JoueurService joueurService;

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = { "inscription" })
	public ModelAndView inscriptionGet(Joueur joueur) {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("inscription");
		return mav;
	}

	@PostMapping("inscription")
	public ModelAndView inscriptionPost(@Valid @ModelAttribute("joueur") Joueur joueur, BindingResult result) {
		if (result.hasErrors()) {
			// La validation de l’objet utilisateur par rapport aux contraintes
			// de validation définies dans la classe métier Utilisateur a produit
			// des erreurs
			ModelAndView mav = inscriptionGet(joueur);
			mav.addObject("joueur", joueur);
			return mav;
		} else {
			joueurService.ajouterJoueur(joueur);
			return new ModelAndView("redirect:/index");
		}
	}

}
