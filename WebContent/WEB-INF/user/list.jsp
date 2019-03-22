<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>User list</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<header class="mb-5">
			<c:import url="/WEB-INF/app/_menu.jsp"/>
			<c:import url="/WEB-INF/app/_flash_message.jsp"/>
		</header>
		
		<div class="container">
			<div class="card">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${sessionScope.users != null and fn:length(sessionScope.users) gt 0}">
								<c:forEach items="${ sessionScope.users }" var="user" varStatus="i">
									<tr>
										<th scope="row">${ i.index }</th>
										<td>${ user['value'].name }</td>
										<td>${ user['value'].email }</td>
										<td>
											<a href="
												<c:url value="/delete">
													<c:param name="email" value="${ user['value'].email }" />
												</c:url>"
												class="btn btn-sm">
												<i class="fas fa-user-times"></i> Supprimer
											</a>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4" style="text-align: center;">Aucun utilisateur enregistré</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	</body>
</html>