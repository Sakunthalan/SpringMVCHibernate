<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACK</title>
<style>
h1
{
 background-color: #8080ff;
}
</style>
</head>
<body background="./resources/cart.jpg">
<%@include file="header.jsp"%>
<br><br><br><br><br>
<center> <h1>Thank you for shopping....!</h1>
<br><br><br><br><br>
<a href="${pageContext.request.contextPath}/" class="btn btn-success">HOME</a>
</center>
<br>

<%@include file="footer.jsp"%>
</body>
</html>