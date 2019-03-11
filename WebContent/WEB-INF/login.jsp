<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.css"> -->
<title>Teeest</title>
</head>
<body>
	<form action="" method="post">
		<fieldset>
			<legend>Connexion</legend>
			<p class="info">${actionMessage}</p>
			<p>
				<label for="email">Adresse
					email <span class="requis">*</span>
				</label> <input type="email" name="email" class="form-control" id="email"
					value="${form['email']}" required />
			</p>
			<p>
				<label for="password">Mot de passe <span class="requis">*</span>
				</label> <input type="password" name="pwd" class="form-control"
					id="password" required value="${form['pwd']}" />
			</p>
			<span class="error">${errors }</span>
			<button type="submit" class="btn btn-primary">Me connecter</button>
		</fieldset>
	</form>
</body>
</html>