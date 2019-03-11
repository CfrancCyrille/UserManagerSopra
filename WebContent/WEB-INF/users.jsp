<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<fieldset>
		<table>
			<tr>
				<th>Email</th>
				<th>Nom</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${sessionScope.users }" var="user"
				varStatus="status">
				<c:choose>
					<c:when test="${status.index%2 == 0}">
						<tr class="pair">
					</c:when>
					<c:otherwise>
						<tr class="impair">
					</c:otherwise>
				</c:choose>
				<td>${user.key }</td>
				<td>${user.value.name }</td>
				<c:url value="/del-user" var="email">
					<c:param name="email" value="${user.key }" />
				</c:url>
				<td><a href="${email }">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
</body>
</html>