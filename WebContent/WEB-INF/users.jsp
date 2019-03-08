<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<c:choose>
		<c:when test="${sessionScope.users != null}">
			<table>
				<tr>
					<th>email</th>
					<th>nom</th>
				</tr>

				<c:forEach items="${ sessionScope.users }" var="user">
				<tr>
				<td><c:out value="${ user.key }" /></td>
					<td><c:out value="${ user.value.name }" /></td>
					<c:url value="/delete" var="myURL">
						<c:param name="email" value="${ user.key }" />
					</c:url>
					<td><a href="${ myURL }">SUPPRIMER</a></td>
				</tr>
					
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
		<p>Aucun utilisateur n'a été trouvé.</p>
	</c:otherwise>
	</c:choose>
</body>
</html>