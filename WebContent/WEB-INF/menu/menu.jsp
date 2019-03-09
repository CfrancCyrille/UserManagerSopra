<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<div>
		<a href="<c:url value="/index"/>">Accueil</a>
	</div>
	<div>
		<a href="<c:url value="/login"/>">Connexion à mon espace</a>
	</div>
	<div>
		<a href="<c:url value="/register"/>">Créer un nouvel utilisateur</a>
	</div>
	<div>
		<a href="<c:url value="/users"/>">Afficher les utilisateurs</a>
	</div>
</div>