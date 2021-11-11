<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Search events</title>
</head>
<body>
	<h1>Planner - Search events</h1>
	<form action="/PlannerWEB/SearchEventsServlet" method="get">
		<table>
			<tr>
				<td>Date</td>
				<td><input type="date" name="date"></td>
			</tr>
		</table>
		<input type="submit" value="Search">
	</form>
	<br>
	<table border="1">
		<tr>
			<th>From</th>
			<th>To</th>
			<th>Event type</th>
			<th>Description</th>
		</tr>
		<c:forEach var="event" items="${events}">
			<tr>
				<td>${event.fromDate}</td>
				<td>${event.toDate}</td>
				<td>${event.eventType.name}</td>
				<td>${event.description}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>