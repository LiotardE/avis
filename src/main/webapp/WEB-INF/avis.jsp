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
<link rel='stylesheet' type='text/css' media='screen'
	href='/css/main.css'>
<title>avis</title>
</head>
<body>
	<c:if test="${sessionScope.utilisateur ne null}">
		<h2>Bonjour ${sessionScope.utilisateur.pseudo} !</h2>
	</c:if>
	<h1>Liste des avis</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Date d’envoi<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Nom du Jeu<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Pseudo du Joueur<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Note<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Image</th>
				<th scope="col">Statut</th>
				<th scope="col">Opérations</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${avis}" var="item" varStatus="boucle">
				<tr>
					<th scope="row">${boucle.count}</th>
					<td>${item.dateEnvoi}</td>
					<td>${item.jeu.nom}</td>
					<td>${item.joueur.pseudo}</td>
					<td>${item.note}</td>  
					<td>${item.jeu.image}</td>
					<td>
						<c:if test="${item.dateModeration eq null}">En attente ...</c:if>					
						<c:if test="${item.dateModeration ne null}">Modéré par ${item.moderateur}</c:if>					
					</td>
					<td><a href="/avis" title="voir les opérations">Voir</a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<p><a href="/avis/ajouter-un-avis" title="ajouter un avis">Ajouter un
		avis</a></p>
	<p><a href="/jeux" title="jeux">Liste des jeux</a></p>			
	<p><a href="/deconnexion" title="déconnexion">Déconnexion</a></p>
	<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>