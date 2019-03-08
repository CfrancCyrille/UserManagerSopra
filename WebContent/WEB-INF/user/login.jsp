<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<fieldset form="connexion">
<legend>Connexion</legend>
<label for="login" class="requis">email</label>
<input id="login" name="login"/>
<br>
<label for="password" class="requis">mot de passe</label>
<input id="password" name="password"/>
<br>
<button type="submit">Valider</button>
<p class="info">${actionMessage}</p>
</fieldset>
</form>
</body>
</html>