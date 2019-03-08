<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User Management</title>
	<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<c:import url="menu/menu.jsp" />
 <c:import url="/WEB-INF/user/form.jsp" />
 </br>
 <c:if test="${isSuccess}">
 	<c:import url="/WEB-INF/user/card.jsp"/>
 </c:if>
</body>
</html>