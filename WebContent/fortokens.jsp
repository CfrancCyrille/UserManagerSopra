<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forTokens var="p"  varStatus="pStatus" items="raoul;john;nicolas" delims=";">
Le ${pStatus.count} ème nom est ${p}<br/>
${p}<br/>
</c:forTokens>
</body>
</html>