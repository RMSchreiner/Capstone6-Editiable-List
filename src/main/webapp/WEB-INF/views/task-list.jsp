<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Tasks</title>
</head>
<body>

<table>
  <tr>
    <th>Complete</th>
    <th>Description</th>
    <th>Due Date</th>
  </tr>
  <c:forEach items = "${tasks}" var = "task">
  <tr>
    <td>
    <c:set var="done" value="${task.complete}"/>
    <c:if test="${done}">
      <a href = "/change-complete?id=${task.id}&complete=${task.complete}">&#10004;</a>
    </c:if>
    <c:if test="${done != true}">
      <a href = "change-complete?id=${task.id}&complete=${task.complete}">&#10060;</a>
    </c:if>
    </td>
    <td>${task.description}</td>
    <td>${task.dueDate}</td>
    <td>
    <a href="/delete?id=${task.id}">&#128465;</a>
    </td>
  </tr>
  </c:forEach> 
</table>

<a href = "/add-task">Add a new Task.</a>

</body>
</html>