<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Liste des utilisateurs</title>
        <link type="text/css" rel="stylesheet" href="styles.css" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	</head>
	<body>
		<div class="container">
	        <c:import url="/WEB-INF/menu/menu.jsp" />
	        <br />
	        
			<table style="width:100%">
	  			<tr>
	    			<th>Email</th>
	    			<th>Nom</th>
	    			<th>Action</th> 
	  			</tr>
	  			<c:choose>
		  			<c:when test="${ sessionScope.users != null}">
		  				<c:forEach var="user" items="${ sessionScope.users }" >
			  				<tr>
			    				<td>${user.key}</td>
			    				<td>${user.value.name}</td> 
			    				<td>
			    					<a href="<c:url value="/delete-user"><c:param name="user_to_delete" value="${user.key}"/></c:url>">
	 									<img src="<c:url value="/images/user_delete.png"/>" alt="Supprimer" />
	 								</a>
								</td>
			  				</tr>
		  				</c:forEach>
		  			</c:when>
		  			<c:otherwise>
		  				<tr>
		    				<td>Aucun user</td>
		    				<td>Aucun user</td> 
		  				</tr>
		  			</c:otherwise>
		  		</c:choose>
			</table>        
        </div>
	</body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({ 
	   type: "GET",
	   dataType: "json",
	   url: "http://192.168.43.157:8080/users",
	   success: function(data){        
	     console.log(data);
	   }
	});
});
</script>