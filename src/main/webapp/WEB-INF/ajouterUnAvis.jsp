<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Ajouter un avis</title>
</head>
<body>
	<h1>Ajouter un avis</h1>
	<form action="/avis/ajouter-un-avis" method="post">
		<select name="JEU" id="jeu-select" class="custom-select" size="3">
			<option selected>--Veuillez choisir un jeu--</option>
			<c:forEach items="${jeux}" var="jeu">			
				<option value="${jeu.id}">${jeu.nom}</option>		
			</c:forEach>
		</select> 
		<input type="text" name="DESCRIPTION" placeHolder="DESCRIPTION">
			
		<select name="NOTE" id="note-select" class="custom-select" size="3">
			<option selected>--Veuillez choisir une note--</option>
				<c:forEach var="i" begin="0" end="20">			
					<option value="${i}">${i}</option>		
				</c:forEach>
			</select> 
		<input type="submit" class="btn btn-info" value="Ajouter un avis">
	</form>
</body>
</html>