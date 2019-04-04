<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fieldset>
	<p>
		<a href="<c:url value="/login"/>">Connexion</a>
	</p>
	<p>
		<a href="<c:url value="/register"/>">Creation d'un utilisateur</a>
	</p>
	<p>
		<a href="<c:url value="/users"/>">Liste des utilisateurs</a>
	</p>
	<p>
		<a href="<c:url value="/index"/>">Accueil</a>
	</p>
</fieldset>