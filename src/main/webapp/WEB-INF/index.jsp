
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Avis Accueil</title>
</head>
<body>
<h1>Connexion</h1>
<c:if test="${param.notification ne null}"><h2>${param.notification}</h2></c:if>
<form action="/connexion" method="post">
	<input type="text" name="PSEUDO" placeHolder="PSEUDO" required autocomplete="on"><br>
	<input type="password" name="MOT_DE_PASSE" placeHolder="Mot de Passe" required><br>
	<input type="submit" class="btn btn-info" value="Connexion">
</form>
<a href="/inscription" title="inscription">S'inscrire</a>

</body>
</html>