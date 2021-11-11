<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Create event</title>
</head>
<body>
	<h1>Planner - Create event</h1>
	<form action="/PlannerWEB/CreateEventServlet" method="post">
		<table>
			<tr>
				<td>Event type</td>
				<td>
					<select name="eventTypeId">
						<c:forEach var="eventType" items="${plannerBean.getTypes()}">
							<option value="${eventType.id}">${eventType.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description"></textarea></td>
			</tr>
			<tr>
				<td>From</td>
				<td><input type="datetime-local" name="fromDateTime"></td>
			</tr>
			<tr>
				<td>To</td>
				<td><input type="datetime-local" name="toDateTime"></td>
			</tr>
		</table>
		<input type="submit" value="Create">
	</form>
</body>
</html>