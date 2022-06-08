<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Détail de l'avis</title>
</head>
<body>
	<h1>Détail de l'avis</h1>

	<h1>Jeu : ${avis.jeu.nom}</h1>

	<div class="card" style="width: 18rem;">
		<img class="card-img-top" src="/img/card1.jpg" alt="Card image cap">
		<div class="card-body">
			<h5 class="card-title">Joueur : ${avis.joueur.pseudo}</h5>
			<p class="card-text">Description : ${avis.description}</p>
			<p class="card-text">date envoi : ${avis.dateEnvoi}</p>
			<p class="card-text">date modération : ${avis.dateModeration}</p>
			<p class="card-text">note du jeu : ${avis.note}</p>
			<a href="#" class="btn btn-primary">Go somewhere</a>
		</div>
	</div>
	<p>
		<a href="/avis" title="retour aux avis">Retour</a>
	</p>
</body>
</html>