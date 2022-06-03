package fr.humanbooster.sparks.avis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import fr.humanbooster.sparks.avis.business.Utilisateur;
import lombok.AllArgsConstructor;

@Component
@Order(2) // Deuxième filtre à exécuter lorsque le serveur reçoit une requête HTTP
@AllArgsConstructor
public class CheckSessionFilter implements Filter {

	private final HttpSession httpSession;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String req = ((HttpServletRequest)request).getRequestURI();
		Utilisateur utilisateur = (Utilisateur) httpSession.getAttribute("utilisateur");
		
		if ((req.startsWith("/avis") || req.startsWith("/jeux")) && utilisateur== null) {
				 
			System.out.println("Pas de session");
			((HttpServletResponse) response).sendRedirect("/index");
		} else {
			chain.doFilter(request, response);
		}
	}

}
