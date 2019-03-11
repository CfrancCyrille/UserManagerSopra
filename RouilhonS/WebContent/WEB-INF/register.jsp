<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
	<c:import url="/WEB-INF/Menu/menu.jsp" />
	<c:import url="/WEB-INF/User/form.jsp" />
	<br />
	<c:if test="${ errorStatus }">
		<c:import url="/WEB-INF/User/card.jsp" />
	</c:if>
</body>
</html>