<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ not empty flashMessage }">
	<div class="alert alert-dismissible alert-${ flashMessage.type }" role="alert">
		<button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
	 	<div class="container">
			<c:out value="${ flashMessage.message }"/>
	 	</div>
	</div>
</c:if>