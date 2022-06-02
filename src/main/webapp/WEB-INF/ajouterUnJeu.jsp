<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un jeu</title>
</head>
<body>
	<h1>Ajouter un jeu</h1>	
	<form:form modelAttribute="jeu" method="post" action="/jeux/ajouter-un-jeu" class="form-modal">
		<div class="form-group mb-3">
			<form:label path="nom" for="inputNom">Nom</form:label>
			<form:input path="nom" class="form-control" id="inputNom" />
			<form:errors path="nom" cssClass="erreur" />
		</div>
		<div class="form-group mb-3">
            <form:label path="editeur" for="inputEditeur">Éditeur</form:label>
            <form:select path="editeur" class="form-control" id="inputEditeur">
                <form:option value="0">Merci de Choisir un Éditeur</form:option>
                <form:options items="${editeurs}" itemValue="id" itemLabel="nom" />
            </form:select>
            <form:errors path="editeur" cssClass="erreur" />
        </div>
        <div class="form-group mb-3">
			<form:label path="dateSortie" for="inputDateSortie">Date de sortie</form:label>
			<form:input path="dateSortie" class="form-control" id="inputdateSortie" />
			<form:errors path="dateSortie" cssClass="erreur" />
		</div>	
		<div class="form-group mb-3">		
			<form:label path="description" for="inputDescription">Description</form:label>			
			<form:textarea path="description" class="form-control" id="inputDescription"></form:textarea>
			<form:errors path="description" cssClass="erreur" />
		</div>
		<div class="form-group mb-3">
            <form:label path="genre" for="inputGenre">Genre</form:label>
            <form:select path="genre" class="form-control" id="inputGenre">
                <form:option value="0">Merci de Choisir un Genre</form:option>
                <form:options items="${genres}" itemValue="id" itemLabel="nom" />
            </form:select>
            <form:errors path="genre" cssClass="erreur" />
        </div>
        <div class="form-group mb-3">
            <form:label path="classification" for="inputClassification">Classification</form:label>
            <form:select path="classification" class="form-control" id="inputClassification">
                <form:option value="0">Merci de Choisir une Classification</form:option>
                <form:options items="${classifications}" itemValue="id" itemLabel="nom" />
            </form:select>
            <form:errors path="classification" cssClass="erreur" />
        </div>
        <div class="form-group mb-3">
            <form:label path="plateformes" for="inputPlateforme">Plateforme</form:label>
            <form:select path="plateformes" class="form-control" id="inputPlateforme">
                <form:option value="0">Merci de Choisir une Plateforme</form:option>
                <form:options items="${plateformes}" itemValue="id" itemLabel="nom" />
            </form:select>
            <form:errors path="plateformes" cssClass="erreur" />
        </div>
        <div class="form-group mb-3">
            <form:label path="modeleEconomique" for="inputModeleEconomique">Modele Economique</form:label>
            <form:select path="modeleEconomique" class="form-control" id="inputModeleEconomique">
                <form:option value="0">Merci de Choisir un Modèle Economique</form:option>
                <form:options items="${modeleEconomiques}" itemValue="id" itemLabel="nom" />
            </form:select>
            <form:errors path="modeleEconomique" cssClass="erreur" />
        </div>
        <form:hidden path="image" value="img/jeux/default.png" />
		<form:button>Ajouter un jeu</form:button>
	</form:form>
	<a href="/index" title="connection">Se connecter</a>

</body>
</html>