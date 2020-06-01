<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->

<link rel="stylesheet" href="bootstrap.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{background-color:${theme};}
</style>
</head>
<body>
 <div class="container">
<h2>Welcome</h2>
<p>${theme}</p>
<br>
<a href = "/my-task">Go to your task</a>
</div>

</body>
</html>