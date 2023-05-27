<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers </title>
<link type="text/css"  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>

<div id="wrapper">

<div  id="header">
<h2>CRM-Customer Relational Manager</h2>
</div>


</div>

<div id="container">
<div id="content">
<!--  add   button   -->
<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd';return false;" class="add-button"/>
<!--  add search  button   -->

<form:form action="search" method="GET" >
Search Customer : <input type="text" name="SearchName"/>

<input type="submit" value="Search" class="add-button"/>

</form:form>

<!--  add out html table  -->

<table>
<tr>

<th> First Name </th> 
<th> Last  Name </th> 
<th> Email </th> 
<th> Action </th>
</tr>

<!--  loop over  -->

<c:forEach var ="tempCustomer" items="${customers}">
<c:url var="updateLink" value="/customer/showFormForUpdate">

<c:param name="customerId" value="${tempCustomer.id }"/>


</c:url>
<c:url var="deleteLink" value="/customer/delete">

<c:param name="customerId" value="${tempCustomer.id }"/>


</c:url>



<tr>

<td> ${tempCustomer.firstName }</td>
<td> ${tempCustomer.lastName }</td>
<td> ${tempCustomer.email }</td>
<td> <a href="${updateLink }">Update</a>
|
<a href="${deleteLink }" onclick="if (!(confirm('Are you sure you want to delete this Customer?')))return false">Delete</a>

</td>
</tr>

</c:forEach>
</table>

</div>

</div>


</body>
</html>