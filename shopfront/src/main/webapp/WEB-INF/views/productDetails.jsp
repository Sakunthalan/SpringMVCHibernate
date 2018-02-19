<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Product Details</title>
</head>
<body>
<%@include file="header.jsp"%>
	<br><br><br><br>
<div class="container">
	<div class="col-sm-1"></div>
	<div class = "col-sm-10">
		<div class="col-sm-5">
			<img src="../resources/${prod.imgName}" width="400" height="300" /></div>
		<div class="col-sm-3 col-sm-offset-1" align="justify">		
			<h1>${prod.pname}</h1>
			<h3>${prod.description}</h3>
			<h3>Price - ${prod.price} Rs. </h3>
			<h4>Supplier - ${prod.supplier.supplierName}</h4> 
			<form:form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/addCart">
				<input type="hidden" name="pid" class="form-control" value="${prod.pid}">
				<%-- <input type="hidden" name="prodname" class="form-control" value="${prod.pid}">--%>
				<input type="text" name="quantity" class="form-control" value="" required><br>
				 <button type="submit" class="btn btn-login">Add To Cart</button>
			
			</form:form>
			
			
		</div>
	
	
		
			
		
		
	</div>
</div>
<br>
<%@include file="footer.jsp"  %>
</body>
</html>