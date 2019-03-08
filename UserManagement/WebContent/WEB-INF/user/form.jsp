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
		<legend>Formulaire d'inscription</legend>
		<form method="post" action="Register">
			<div>
				<div><label>Adresse mail</label><input type="Text" id="Email" name="Email" value=${form["email"]}><span class="error">${error['email']}</span></div>
				<div><label>Mot de passe</label><input type="Password" id="Password" name="Password" value=${form["pwd"]}><span class="error">${error['pwd']}</span></div>
				<div><label>Confirmation mot de passe</label><input type="Password" id="PasswordConfirm" name="PasswordConfirm" value=${form["pwd"]}><span class="error">${error['pwd']}</span></div>
				<div><label>Pseudo</label><input type="Text" id="Pseudo" name="Pseudo" value=${form["pseudo"]}><span class="error">${error['pseudo']}</span></div>
				<button type="Submit" class="btn-login">Valider</button>
			</div>
		</form>
		<p class="result">${msgValidation}</p>
	</fieldset>
</body>
</html>