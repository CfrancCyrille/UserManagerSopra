<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/styles.css" />
<title>Insert title here</title>
</head>
<body>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp" />
	<br />
	<c:import url="/WEB-INF/user/form.jsp" />
	<br />
	<c:if test="${ !errorStatus }">
		<c:import url="/WEB-INF/user/card.jsp" />
	</c:if>
</body>
</body>
</html>