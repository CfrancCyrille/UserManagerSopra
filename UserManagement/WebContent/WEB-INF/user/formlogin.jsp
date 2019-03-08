<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend>Formulaire de connexion</legend>
		<form method="post" action="Login">
			<div>
				<div><label>Adresse mail</label><input type="Text" id="Email" name="Email" value=${email}></div>
				<div><label>Mot de passe</label><input type="Password" id="Password" name="Password"></div>
				<button type="Submit" class="btn-login">Valider</button>
			</div>
		</form>
		<p class="result">${msgLogin}</p>
	</fieldset>
</body>
</html>