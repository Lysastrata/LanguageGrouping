<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<c:forEach items="${languages}" var="language" varStatus="loop">
			<tr>    
			    <td><a href="/languages/show/${language.id}"><c:out value="${language.name}"/></a></td>
			    <td><c:out value="${language.creator}"/></td>
			    <td><c:out value="${language.version}"/></td>
			    <td><a href="/languages/delete/${language.id}">Delete</a> <a href="/languages/edit/${language.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<form:form method="POST" action="/languages" modelAttribute="language">
	    <form:label path="name">Name
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label>
	    
	    <form:label path="creator">creator
	    <form:errors path="creator"/>
	    <form:input path="creator"/></form:label>
	    
	    <form:label path="version">version
	    <form:errors path="version"/>
	    <form:input path="version"/></form:label>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>