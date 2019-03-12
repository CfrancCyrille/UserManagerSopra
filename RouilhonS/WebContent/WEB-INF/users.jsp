<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link type="text/css" rel="stylesheet" href="styles.css" />
</head>
<body>
	<c:import url="/WEB-INF/Menu/menu.jsp" />
	<c:choose>
		<c:when test="${sessionScope.users != null }">
		<br>
			<table>
				<tr>
					<td>Email</td>
					<td>Name</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${sessionScope.users }" var="user">
					<td><c:out value="${user.key }" /></td>
					<td><c:out value="${user.value.name }" /></td>
					<td><a href="http://localhost:8080/UserManager3/DelUser?em=${user.value.getEmail()}"><img style = "height:30px;width:30px;" src="http://localhost:8080/UserManager3/images/delete.png" alt="Image"/></a></td>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<br>
			<p>Aucun utilisateurs enregistrés pour le moment</p>
		</c:otherwise>

	</c:choose>

</body>
</html>