<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
	<legend> Menu </legend>
	<a href="">Connexion � mon espace</a>
	<br>
	<a href="<c:url value="/Register.php" />">Cr�er un nouvel utilisateur</a>
	<br>
	<a href="<c:url value="/users" />">Afficher les utilisateurs</a>
	<br>
	<a href="<c:url value="/index.jsp" />">Accueil</a>
	
</fieldset>
