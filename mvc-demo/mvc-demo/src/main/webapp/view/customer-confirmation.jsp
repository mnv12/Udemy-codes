<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@  taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Confirmation Page</title>
</head>
<body>
The Customer is Confirmed : ${customer.firstName }  ${customer.lastName }

Total Free Passes :${customer.freePasses }

The Postal Code is :${customer.postalCode }

The Course Code is :${customer.courseCode }

</body>
</html>