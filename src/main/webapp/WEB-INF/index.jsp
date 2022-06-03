
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
 <!-- Custom styles for this template -->
    <link href="cover.css" rel="stylesheet">
  </head>
<title>Avis Accueil</title>
</head>
<body>
<div>
	<h1>Connexion</h1>
	<c:if test="${param.notification ne null}"><h2>${param.notification}</h2></c:if>
	<form action="/connexion" method="post">
		<input type="text" name="PSEUDO" placeHolder="PSEUDO" required autocomplete="on"><br>
		<input type="password" name="MOT_DE_PASSE" placeHolder="Mot de Passe" required><br>
		<input type="submit" class="btn btn-info" value="Connexion">
	</form>
	<a href="/inscription" title="inscription">S'inscrire</a>
</div>


 <body class="d-flex h-100 text-center text-white bg-dark">
    
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="mb-auto">
    <div>
      <h3 class="float-md-start mb-0">Cover</h3>
      <nav class="nav nav-masthead justify-content-center float-md-end">
        <a class="nav-link fw-bold py-1 px-0 active" aria-current="page" href="#">Home</a>
        <a class="nav-link fw-bold py-1 px-0" href="#">Features</a>
        <a class="nav-link fw-bold py-1 px-0" href="#">Contact</a>
      </nav>
    </div>
  </header>

  <main class="px-3">
    <h1>Cover your page.</h1>
    <p class="lead">Cover is a one-page template for building simple and beautiful home pages. Download, edit the text, and add your own fullscreen background photo to make it your own.</p>
    <p class="lead">
      <a href="#" class="btn btn-lg btn-secondary fw-bold border-white bg-white">Learn more</a>
    </p>
  </main>

  <footer class="mt-auto text-white-50">
    <p>Cover template for <a href="https://getbootstrap.com/" class="text-white">Bootstrap</a>, by <a href="https://twitter.com/mdo" class="text-white">@mdo</a>.</p>
  </footer>
</div>


    

</body>
</html>