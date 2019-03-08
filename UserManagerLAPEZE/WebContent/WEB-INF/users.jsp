<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="menu/menu.jsp" />
<html>
<head>
	<title>Utilisateurs</title>
	<style>
		@CHARSET "ISO-8859-1";
 body, p, legend, label, input {
 font: normal 8pt verdana, helvetica, sans-serif;
 }
 fieldset {
 padding: 10px;
 border: 1px #0568CD solid;
 }
 legend {
 font-weight: bold;
 color: #0568CD;
 }
 form label {
 float: left;
 width: 200px;
 margin: 3px 0px 0px 0px;
 }
 form input {
 margin: 3px 3px 0px 0px;
 border: 1px #999 solid;
 }
 form input.sansLabel {
 margin-left: 200px;
 }
 form .requis {
 color:
}
/* Status */
 .error {
color: #900;
}
.info {
font-style: italic;
color: #E8A22B;
}
table{
border-collapse: collapse;
}
tr.pair{
background-color: #fff;
}
tr.impair{
background-color: #ddd;
}
th{
color: #0568CD;
border: 1px solid #0568CD;
padding: 5px;
}
th.action{
border: 1px solid #900;
color: #900;
}
td{
border: 1px solid #ddd;
padding: 5px;
}
td.action{
text-align: center;
}
	</style>
</head>
<body>
<fieldset>
<c:choose>
<c:when test="${ empty sessionScope.users }">
<p class="erreur">Aucun utilisateur enregistré</p>
</c:when>
<c:otherwise>
	<table>
		<tr>
		<th>Email</th>
		<th>Nom</th>
		<th>Delete</th>
		</tr>
		<c:forEach items="${ sessionScope.users }" var="mapUsers" varStatus="boucle">
		<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
		<td>${ mapUsers.value.getEmail() }</td>
		<td>${ mapUsers.value.getNom() }</td>
			<td>
				<a href=" <c:url value="/del_user" > <c:param name="email" value="${ mapUsers.key }" /></c:url>">
				<img src="<c:url value="/images/supprimer.png"/>" alt="Supprimer" /></a>
			</td>
		</tr>
		</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
</fieldset>
</body>
</html>