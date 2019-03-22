<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-dark bg-dark">
	<a href="<c:url value="/"/>">
		<span class="navbar-brand mb-0 h1">UserManagement</span>
	</a>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
  
  	<div class="collapse navbar-collapse" id="navbarToggler">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/login"/>">Connexion</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/register"/>">S'enregistrer</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/users"/>">Liste des Utilisateurs</a>
			</li>
		</ul>
	</div>
</nav>