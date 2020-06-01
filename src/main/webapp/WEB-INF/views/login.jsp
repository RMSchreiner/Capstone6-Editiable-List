<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="bootstrap.css">
<style>
body{background-color: "${theme}";}
</style>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Login</h1>
		<h2>${message}</h2>
		<form action="/login-submit" method="post">
			<label for="email"><b>Email</b></label> <input type="text"
				placeholder="Enter Email Address" name="email" required> 
		    <label for="password"><b>Password</b></label> <input
				type="password" placeholder="Enter Password" name="password"
				required> <br> <br>
			<button type="submit">Login</button>

		</form>
		<br> <a href="/create-account">Create a new account</a>
	</div>

</body>
</html>