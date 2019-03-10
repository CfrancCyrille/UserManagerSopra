<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<br>
	Bienvenue dans l'appli Java EE. 
	<br>
	<img src="<c:url value="/images/javaEEimage.png"/>" />
</body>
</html>