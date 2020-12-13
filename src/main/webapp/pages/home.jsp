<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.inline-block-child {
	  display: inline-block;
	}
</style>
</head>
<body>
<div class = "parent">
	<div class='child inline-block-child'>
		<h1>Add Alien details</h1>
		<form:form method="get" action="/addAlien" modelAttribute="alien">
		Enter the Alient id : 
	    <form:input path="aid" />
			<br>
	    Enter the Alient Name : 
	    <form:input path="aName" />
			<br>
	    Enter the Alien Language : 
	    <form:input path="lang" />
			<br>
			<input type="submit" value="Add">
		</form:form>

		<br> <br> <br> <br> <br>
		<h2>Aliens in Database are</h2>

		<table border="3" BORDERCOLOR=RED>
			<thead>
				<tr>
					<td>Alien Id</td>
					<td>Alien Name</td>
					<td>Alien Language</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${aliens}" var="alien">
					<tr>
						<td>${alien.aid}</td>
						<td>${alien.aName}</td>
						<td>${alien.lang}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class='child inline-block-child'>
		<h2>Table in reverse order</h2>
		<table border="3" BORDERCOLOR=RED>
			<thead>
				<tr>
					<td>Alien Id</td>
					<td>Alien Name</td>
					<td>Alien Language</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${revAliens}" var="alien">
					<tr>
						<td>${alien.aid}</td>
						<td>${alien.aName}</td>
						<td>${alien.lang}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class='child inline-block-child' >
	
	<form:form method="get" action="/getAlienByLanguage" modelAttribute="langAlien">
		Filter alien by language
		<br>
		Enter the language : 
		<form:input path="lang"/>
		<input type="submit" value="Find"/>
	</form:form>
	
	
		<h2>Aliens of Language</h2>
		<table border=3px BORDERCOLOR=RED>
			<thead>
				<tr>
					<td>Alien Id</td>
					<td>Alien Name</td>
					<td>Alien Language</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${langAliens}" var="langAlien">
					<tr>
						<td>${langAliens.aid}</td>
						<td>${langAliens.aName}</td>
						<td>${langAliens.lang}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>