<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>S'enregistrer</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
	</head>
	<body>
		<header class="mb-5">
			<c:import url="/WEB-INF/app/_menu.jsp"/>
			<c:import url="/WEB-INF/app/_flash_message.jsp"/>
		</header>
		
		<div class="container">
			<div class="card">
				<div class="card-header">
					<h2>Connexion</h2>
				</div>
				
				<div class="card-body">
					<form method="POST" action="login">
						<div class="form-group">	
							<label for="inputEmail">Adresse email <span class="required">*</span></label>
				  			<input type="email" class="form-control" id="inputEmail" name="email" value="${ form.email }" required>
							<p class="text-danger"><c:out value="${ errors.email }"/></p>
						</div>
						
						<div class="form-group">	
							<label for="inputPassword">Mot de passe <span class="required">*</span></label>
				  			<input type="password" class="form-control" id="inputPassword" name="password" required>
							<p class="text-danger"><c:out value="${ errors.password }"/></p>
						</div>
						
						<input class="btn btn-primary" type="submit" value="S'enregister">
					</form>
				</div>
				
				<c:if test="${ not empty errorStatus and !errorStatus }">
					<div class="mt-5">
						<c:import url="/WEB-INF/user/_card.jsp" />
					</div>	
				</c:if>
			</div>
		</div>
		
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	</body>
</html>