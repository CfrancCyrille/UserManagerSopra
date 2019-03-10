<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste des utilisateurs</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<c:choose>
		<c:when test="${ sessionScope.users != null }">
			<table>
				<tr>
					<td>email</td>
					<td>nom</td>
				</tr>
				<c:forEach items="${ sessionScope.users }" var="user">
					<tr>
						<td><c:out value="${user.key}"></c:out></td>
						<td><c:out value="${user.value.name}"></c:out></td>
						<td>
							<a href="http://localhost:8080/UserManager4/del-user?em=${user.value.getEmail()}">
								<img src="<c:url value="/images/suppr.png"/>"height=30 width=30  alt="Supprimer" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<br>
			<p>Aucun utilisateur enregistré pour l'instant</p>
			<p>
				<c:out value="${ sessionScope }"></c:out>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>