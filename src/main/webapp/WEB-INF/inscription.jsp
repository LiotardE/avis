<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<h1>Inscription</h1>	
	<form:form modelAttribute="joueur" method="post" action="/inscription" class="form-modal">
		<div class="form-group mb-3">
			<form:label path="pseudo" for="inputPseudo">Pseudo</form:label>
			<form:input path="pseudo" class="form-control" id="inputPseudo" />
			<form:errors path="pseudo" cssClass="erreur" />
		</div>	
		<div class="form-group mb-3">
			<form:label path="email" for="inputEmail">Email</form:label>
			<form:input path="email" class="form-control" id="inputEmail" />
			<form:errors path="email" cssClass="erreur" />
		</div>
		<div class="form-group mb-3">
			<form:label path="motDePasse" for="inputMotDePasse">Mot de passe</form:label>
			<form:input path="motDePasse" class="form-control" id="inputMotDePasse" />
			<form:errors path="motDePasse" cssClass="erreur" />
		</div>
		<div class="form-group mb-3">
			<form:label path="dateDeNaissance" for="inputDateDeNaissance">Date de naissance</form:label>
			<form:input path="dateDeNaissance" class="form-control" id="inputDateDeNaissance" />
			<form:errors path="dateDeNaissance" cssClass="erreur" />
		</div>		
		<form:button>S'inscrire</form:button>
	</form:form>
	<a href="/index" title="connection">Se connecter</a>

</body>
</html>