<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <link type="text/css" rel="stylesheet" href="./styles.css" /> -->
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
</style>
</head>
<body>
	<c:import url="/WEB-INF/menu/menu.jsp"/>
	<c:import url="/WEB-INF/user/form.jsp"/>
	<br/>
	<c:if test="${ !errorStatus }">
	<c:import url="/WEB-INF/user/card.jsp"/>
	</c:if>
	<p class="info">${actionMessage}</p>
</body>
</html>