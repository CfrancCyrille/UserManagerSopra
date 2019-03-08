<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
	<a href="<c:url value="/index"/>">Acceuil</a>
	<br>
	<a href="<c:url value="/register"/>">Créer un nouvel utilisateur</a>
	<br>
	<a href="<c:url value="/login"/>">Connexion à mon espace</a>
	<br>
	<a href="<c:url value="/users"/>">Liste des utilisateurs</a>
	<c:choose>
	<c:when test="${sessionScope.loggedUser != null}">
	<br><p>Bonjour à toi <c:out value="${sessionScope.loggedUser.name}"/></p>
	</c:when>
	</c:choose>
	</fieldset>
	
</body>
</html>