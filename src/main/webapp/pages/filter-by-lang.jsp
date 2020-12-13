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
	<div class="parent">
		<div class='child inline-block-child'>
			<form method="get" action="/getAlienByLanguage">
		<h1>Filter alien by language</h1>
		<br>
		Enter the language : 
		<input type="text" name="lang"/>
				<input type="submit" value="Find" />
			</form>


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
							<td>${langAlien.aid}</td>
							<td>${langAlien.aName}</td>
							<td>${langAlien.lang}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>