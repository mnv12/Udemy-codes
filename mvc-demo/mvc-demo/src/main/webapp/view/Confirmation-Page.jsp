<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
Student  Name : ${student.firstName } ${student.lastName }

<br><br>

Country : ${student.country}

<br><br>

Favourite Language :${student.favouritelanguage }
<br><br>

Operating Systems :

<ul>
<c:forEach var="temp" items="${student.operatingSystem }">

<li>${temp}</li>
</c:forEach>


</ul>



</body>
</html>