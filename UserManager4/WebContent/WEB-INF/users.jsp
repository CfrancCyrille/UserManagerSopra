<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="styles.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="menu/menu.jsp" />
	<table>
		<tr>
			<th>Email</th>
			<th>Nom</th>
			<th>Supprimer</th>
		</tr>
		<c:forEach items="${sessionScope.users}" var="user" varStatus="status">
			<tr>
				<td>${user.key}</td>
				<td>${user.value.name}</td>
				<c:url value="/del-user" var="email">
				<c:param name="email" value="${user.key }"/>
				</c:url>
				<td><a href="${email }">Supprimer</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>