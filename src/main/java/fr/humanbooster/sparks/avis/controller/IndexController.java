package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.JoueurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class IndexController {

	// Attributs (toujours au début de la classe)
	// (quelles sont les dépendances ?)
	private final JoueurService joueurService;
	private final HttpSession httpSession;

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = { "/", "/index", "/accueil" })
	public ModelAndView indexGet() {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/connexion")
	public ModelAndView connexionPost(@RequestParam("PSEUDO") String pseudo, 
								@RequestParam("MOT_DE_PASSE") String motDePasse) {
		Joueur joueur = joueurService.recupererJoueur(pseudo, motDePasse);
		
		if (joueur == null || !joueur.getMotDePasse().equals(motDePasse)) {			
			ModelAndView mav =new ModelAndView("redirect:index");
			mav.addObject("notification", "Mot de passe et/ou email incorrect");
			return mav;
		}
		else {
			// L'utilisateur a fourni les bonnes informations (pseudo et mot de passe)
			
			// On ajoute en session HTTP l'objet joueur
			httpSession.setAttribute("joueur", joueur);
			
			// On redirige vers l'URL avis
			// équivalent de ce que l'on faisait à l'époque de JEE en écrivant :
			// response.sendRedirect("avis");
			// Après le mot redirect, on fait référence à une URL et non pas à une vue
			ModelAndView mav = new ModelAndView("redirect:/avis");
			return mav;
		}
			
	}

//	/**
//	 * Principe Hollywood : ne nous appelez pas, nous vous appelerons
//	 * Spring va instancier l'objet métier joueur
//	 * 
//	 * @param joueur
//	 * @return
//	 */
//	@GetMapping
//	public ModelAndView inscriptionGet()
}
