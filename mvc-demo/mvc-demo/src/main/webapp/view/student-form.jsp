<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration </title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

First Name : <form:input path="firstName"/>



<br><br>
Last Name :  <form:input path="lastName"/>


<br><br>
Country :

<form:select path="country">
<form:options items="${student.hashMap }"/>
</form:select>

<br><br>

Favourite Language :

Java : <form:radiobutton path="favouritelanguage" value="Java"/>
C# :<form:radiobutton path="favouritelanguage" value="C#"/>
Python :<form:radiobutton path="favouritelanguage" value="Python"/>
Ruby :<form:radiobutton path="favouritelanguage" value="Ruby"/>


<br> <br>



Linux: <form:checkbox path="operatingSystem" value="Linux"/>
Windows: <form:checkbox path="operatingSystem" value="Windows"/>
Mac-OS: <form:checkbox path="operatingSystem" value="Mac-OS"/>


<input type="submit" value="submit">
  </form:form>




</body>
</html>