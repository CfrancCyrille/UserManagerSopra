<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form method="POST" action="register">
	<div class="form-group">
		<label for="inputName">Nom</label>
 			<input type="text" class="form-control" id="inputName" name="name" value="${ form.name }">
 			<p class="text-danger"><c:out value="${ errors.name }"/></p>
	</div>
	
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
	
	<div class="form-group">	
		<label for="inputPasswordRepeat">Confirmer le mot de passe <span class="required">*</span></label>
 			<input type="password" class="form-control" id="inputPasswordRepeat" name="passwordRepeat" required>
	</div>
	
	<input class="btn btn-primary" type="submit" value="S'enregister">
</form>