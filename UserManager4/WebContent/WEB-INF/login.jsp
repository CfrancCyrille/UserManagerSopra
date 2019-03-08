<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="styles.css" />
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ connected }">
		<c:import url="/WEB-INF/menu/menu.jsp" />
	</c:if>
	<fieldset>
		<legend>Connexion</legend>
		<form method="POST" action="login">
			<label for="username">Email : </label>
			<input type="text"id="username" name="username" size="20" maxlength="60" />
			<br/>
			<label for=password">Mot de passe : </label>
			<input type="password" id="password" name="password" size="20" maxlength="20" />
			<br/>
			<c:if test="${ !errorStatus }">
				<span style="color:red"> ${ error } </span>
			</c:if>
			<br/>
			<input type="submit" value="Connexion" />
		</form>
	</fieldset>
</body>
</html>