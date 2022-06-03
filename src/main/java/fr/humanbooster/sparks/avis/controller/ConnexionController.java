package fr.humanbooster.sparks.avis.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import fr.humanbooster.sparks.avis.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ConnexionController {

	private final HttpSession httpSession;
	
	private final UtilisateurService utilisateurService;
	
	@PostMapping("/connexion")
	public ModelAndView connexionPost(@RequestParam("PSEUDO") String pseudo, 
								@RequestParam("MOT_DE_PASSE") String motDePasse) {
		Utilisateur utilisateur = utilisateurService.recupererUtilisateur(pseudo, motDePasse);
		
		if (utilisateur == null || !utilisateur.getMotDePasse().equals(motDePasse)) {			
			ModelAndView mav =new ModelAndView("redirect:index");
			mav.addObject("notification", "Mot de passe et/ou email incorrect");
			return mav;
		}
		else {
			// L'utilisateur a fourni les bonnes informations (pseudo et mot de passe)
			
			// On ajoute en session HTTP l'objet joueur
			httpSession.setAttribute("utilisateur", utilisateur);
			
			// On redirige vers l'URL avis
			// équivalent de ce que l'on faisait à l'époque de JEE en écrivant :
			// response.sendRedirect("avis");
			// Après le mot redirect, on fait référence à une URL et non pas à une vue
			ModelAndView mav = new ModelAndView("redirect:/avis");
			return mav;
		}
			
	}
}
