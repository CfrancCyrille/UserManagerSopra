<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page errorPage="WEB-INF/errorpage.jsp"%>
<%
 int var = 90;
 %>
 <% 
 var = var / 0;
 %>
 <%=var %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!String contenu[] = { "raoul", "jogn", "nicolas" };%>
	<%!private String printContenu() {
		String res = "";
		for (int i = 0; i < contenu.length; i++) {
			res += "Le " + i + " ème nom est " + contenu[i];
			res += "<br>";
		}
		return res;
	}%>
	<%=printContenu()%>

</body>
</html>