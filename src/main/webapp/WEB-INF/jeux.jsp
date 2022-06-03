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
<title>jeux</title>
</head>
<body>
	<c:if test="${sessionScope.utilisateur ne null}">
		<h2>Bonjour ${sessionScope.utilisateur.pseudo} !</h2>
	</c:if>
	<h1>Liste des jeux</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Image<a href="" title=""></a></th>
				<th scope="col">Nom<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Editeur<a href="" title=""><img
						class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
				<th scope="col">Opérations<a href="" title=""></a></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${jeux}" var="jeu" varStatus="boucle">
				<tr>
					<th scope="row">${boucle.count}</th>
					<td>${jeu.image}</td>
					<td>${jeu.nom}</td>
					<td>${jeu.editeur.nom}</td>
					<td>
						<a href="/jeux/voir?idJeu=${jeu.id}" title="voir le jeu">Voir</a> 
						<c:if test="${sessionScope.utilisateur.getClass().getSimpleName() eq 'Moderateur'}">
							<a href="/jeux/modifier-jeu?idJeu=${jeu.id}"" title="modifier un jeu">Modifier</a> 
							<a href="#" title="téléverser une image">Téléverser l'image</a> 
							<a href="/jeux/delete-jeu?idJeu=${jeu.id}" title="supprimer-un-jeu">Supprimer</a>							
						</c:if>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>


	<c:if test="${sessionScope.utilisateur.getClass().getSimpleName() eq 'Moderateur'}">
		<p>
			<a href="/jeux/ajouter-un-jeu" title="ajouter un jeu">Ajouter un
				jeu</a>
		</p>
	</c:if>

	<p>
		<a href="/deconnexion" title="déconnexion">Déconnexion</a>
	</p>

</body>
</html>