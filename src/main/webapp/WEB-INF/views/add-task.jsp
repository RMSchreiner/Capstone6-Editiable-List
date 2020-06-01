<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->

<link rel="stylesheet" href="bootstrap.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<h1>Add a task</h1>

		<form action="/submit-task">
			<label for="description">Description:</label><br> <input
				type="text" id="description" name="description"><br> <br>
			<label for="dueDate">Due Date:</label><br> <input type="text"
				id="dueDate" name="dueDate" value="yyyy-mm-dd"><br> <br>
			<br> <input type="submit" value="Submit">

		</form>

	</div>
</body>
</html>