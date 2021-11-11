<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<body>
	<h1>Planner - Login</h1>
	<form action="/PlannerWEB/LoginServlet" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="Login">
	</form>
	<br>
	<a href="/PlannerWEB/register.jsp">Click here if you do not have an account.</a>
</body>
</html>