<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel='stylesheet' type='text/css' media='screen' href='/css/main.css'> 
<title>avis</title>
</head>
<body>
<h1>Liste des avis</h1>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Date d’envoi<a href="" title=""><img class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
      <th scope="col">Nom du Jeu<a href="" title=""><img class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
      <th scope="col">Pseudo du Joueur<a href="" title=""><img class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
      <th scope="col">Note<a href="" title=""><img class="icon icon-s" src="/img/sort-yellow.png" alt="Trier"></a></th>
      <th scope="col">Image</th>
      <th scope="col">Statut</th>
      <th scope="col">Opérations</th>     
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>18</td>
      <td>oui</td>
      <td>joueur</td>
      <td>1</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
      <td>18</td>
      <td>oui</td>
      <td>joueur</td>
      <td>1</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
      <td>18</td>
      <td>oui</td>
      <td>joueur</td>
      <td>1</td>
    </tr>
  </tbody>
</table>
	<a href="/avis/ajouter-un-avis" title="ajouter un avis">Ajouter un
		avis</a>
	<a href="/deconnexion" title="déconnexion">Déconnexion</a>
</body>
</html>