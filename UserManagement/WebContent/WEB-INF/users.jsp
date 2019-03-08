<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Listes des utilisateurs</title>
	<link type="text/css" rel="stylesheet" href="http://localhost:8080/UserManagement5/style.css" />
</head>
<body>
	<c:import url="menu/menu.jsp" />
	<table>
		<thead> <!-- En-tête du tableau -->
       		<tr>
           		<th>Email</th>
           		<th>Pseudo</th>
           		<th>Hash</th>
           		<th>Action</th>
       		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="type" items="${users}">
  			<tr>
		    	<td>${type.value.getEmail()}</td>
		    	<td>${type.value.getPseudo()}</td>
		    	<td>${type.value.getMdp()}</td>
		    	<td><a href="http://localhost:8080/UserManagement5/DelUser?em=${type.value.getEmail()}"><img style = "height:30px;width:30px;" src="http://localhost:8080/UserManagement4/images/delete.png" alt="Ici est sensé être une image"/></a></td>
  			</tr>
  			</c:forEach>
  		</tbody>
	</table>
</body>
</html>