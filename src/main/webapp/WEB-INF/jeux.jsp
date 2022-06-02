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
	<c:if test="${sessionScope.joueur ne null}">
		<h2>Bonjour ${sessionScope.joueur.pseudo} !</h2>
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
					<td><a href="/avis" title="voir les opérations">Voir</a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<p><a href="/jeux/ajouter-un-jeu" title="ajouter un jeu">Ajouter un
		jeu</a></p>
	<p><a href="/deconnexion" title="déconnexion">Déconnexion</a></p>
	
</body>
</html>