<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->

<link rel="stylesheet" href="bootstrap.css">
<meta charset="ISO-8859-1">
<title>Create an Account</title>
</head>
<body>

 <div class="container">
 
<h1> Fill in the fields below </h1>
<h2>${message}</h2>

<form action="/submit-account" method="post">
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">Email Address:</label><br>
  <input type="text" id="email" name="email"><br>
   <label for="password">Password:</label><br>
  <input type="password" id="password" name="password" value=""><br>
 <label for="password">Re-enter Password:</label><br>
  <input type="password" id="pTest" name="pTest"><br><br>
  <label>Select Theme</label><br>
  <label for="light">Light</label>
  <input type="radio" id="light" name="theme" value="white"><br>
    <label for="dark">Dark</label>
  <input type="radio" id="dark" name="theme" value="grey">
  <br><br>
  <input type="submit" value="Submit">
  
</form> 

 </div>
 
</body>
</html>