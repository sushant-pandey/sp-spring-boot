<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add Alien details</h1>
	<form:form method="get" action="/addAlien" modelAttribute="alien">
		Enter the Alient id : 
	    <form:input path="aid"/>
	    <br>
	    Enter the Alient Name : 
	    <form:input path="aName"/>
	    <br>
	    Enter the Alien Language : 
	    <form:input path="lang"/>
	    <br>
	    <input type="submit" value = "Add">
	</form:form>
</body>
</html>