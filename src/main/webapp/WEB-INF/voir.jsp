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
<title>Détail du jeu</title>
</head>
<body>
<h1>Détail du jeu</h1>

${jeu.nom}

<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="/img/card1.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">${jeu.nom}</h5>
    <p class="card-text">${jeu.description}</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>
<p>
		<a href="/jeux" title="retour aux jeux">Retour</a>
	</p>
</body>
</html>