<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register</title>
</head>
<body>
	<h1>Planner - Register</h1>
	<form action="/PlannerWEB/CreateAccountServlet" method="post">
		<table>
			<tr>
				<td>First name</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last name</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="Register">
	</form>
	<br>
	<a href="/PlannerWEB/index.jsp">Click here if you already have an account.</a>
</body>
</html>