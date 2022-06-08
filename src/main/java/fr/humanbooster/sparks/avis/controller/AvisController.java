package fr.humanbooster.sparks.avis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.humanbooster.sparks.avis.business.Avis;
import fr.humanbooster.sparks.avis.business.Joueur;
import fr.humanbooster.sparks.avis.service.AvisService;
import fr.humanbooster.sparks.avis.service.CSVExportService;
import fr.humanbooster.sparks.avis.service.JeuService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class AvisController {

	// Attributs (toujours au début de la classe)
	// (quelles sont les dépendances ?)	
	
	private static final int NB_AVIS_PAR_PAGE = 5;
	
	private final HttpSession httpSession;
	private final AvisService avisService;
	private final JeuService jeuService;
	private final CSVExportService csvExportService;

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = "/avis")
	public ModelAndView avisGet(@PageableDefault(size = NB_AVIS_PAR_PAGE, sort = "dateEnvoi") Pageable pageable,
			@RequestParam(name="numeroDePage", defaultValue = "0") int numeroDePage, 
			@RequestParam(name="sort", defaultValue = "nom") String sort) {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("avis");
		// Récupérer les avis dans la base de données
		mav.addObject("avis", avisService.recupererAvis(pageable.withPage(numeroDePage)));
		mav.addObject("sort", sort);
		// Met en session la page choisie
				if (pageable != null) {
					httpSession.setAttribute("numeroDePage", numeroDePage);
				}
		// Renvoyer la vue
		return mav;
	}

	// Toutes les méthodes de ce conrôleur devront renvoyer un objet de type
	// ModelAndView
	// (métaphore de la Danette Pop)
	// On indique sur quelle(s) URL(s) la méthode va écouter
	// Autrement dit : quelle(s) sont la ou les URLs que la méthode prend en charge
	// Equivalent de @WebServlet
	@GetMapping(value = "/avis/ajouter-un-avis")
	public ModelAndView avisAjouterGet() {
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
		Joueur joueur = (Joueur)httpSession.getAttribute("joueur");
		System.out.println(joueur);
		//Avis avis = avisService.ajouterAvis(idJeu, description, note, (Joueur) httpSession.getAttribute("joueur"));
		Avis avis = avisService.ajouterAvis(idJeu, description, note, joueur);
		System.out.println(avis);
		return new ModelAndView("redirect:/avis");
	}
	
	@GetMapping(path = "/avis/export", produces = "text/csv")
	public void obtenirExportGet(HttpServletRequest request, HttpServletResponse
			response) throws IOException {
		// Doc :
        // https://developer.mozilla.org/fr/docs/Web/HTTP/Headers/Content-Disposition
        response.addHeader("Content-Disposition", "attachment; filename = \"avis.csv\"");
        csvExportService.exportCSV(response.getWriter());
			}
		
	@GetMapping(value = "/avis/voir")
	public ModelAndView avisVoirGet(@RequestParam("idAvis") Long idAvis) {
		// On déclare et on instancie un objet de type ModelAndView
		ModelAndView mav = new ModelAndView();
		// On définit le nom de la vue (== crème dessert)
		// Equivalent de request.getRequestDispatcher("WEB-INF/index.jsp")
		mav.setViewName("voirAvis");
		mav.addObject("avis", avisService.recupererAvis(idAvis));
		return mav;
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
