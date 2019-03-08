<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link type="text/css" rel="stylesheet" href="./styles.css" /> -->
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp"/>
	<c:import url="/WEB-INF/user/formLogin.jsp"/>
	<br/>
	<c:if test="${ !errorStatus }">
	<c:import url="/WEB-INF/user/card.jsp"/>
	</c:if>
	<p class="info">${actionMessage}</p>
</body>
</html>