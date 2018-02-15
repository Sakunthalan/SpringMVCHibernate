<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>My Cart</title>
</head>
<body>
<%@include file="header.jsp"%>
	<br><br><br>
<div class="container">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
		<div class ="row">
			<div class="col-sm-4">
			<img src="./resources/cartview.jpg" width="300" height="200" /></div>
			<div class="col-sm-6 col-sm-offset-1"><h2>Cart</h2></div>
		</div>
		<br><br>
		<%! int total=0; %>
		<div class="row">
			<table class="table table-striped table-responsive">		 
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Product Image</th>
					<th>Total</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cart" items="${cartInfo}">
					<tr>
						<td>${cart.cartProductName}</td>
						<td>${cart.cartPrice}</td>
						<td>${cart.quantity}</td>
						<td><img src="./resources/${cart.cartImage}" width="50" height="50" /></td>
						<td>${cart.cartPrice * cart.quantity}</td>
						<td><a href="${pageContext.request.contextPath}/deleteCart/${cart.cartId}" class="btn btn-info"><span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
		</div>
		<div class="row"><h4><b>Grand Total </b> ${cartInfo.stream().map(cart -> cart.cartPrice * cart.quantity).sum()} </h4> </div>
		<div class="row">
		<div class="form-group">
				<div class="col-sm-4"><a href="${pageContext.request.contextPath}/" class="btn btn-primary">Continue Shopping</a></div>
				<div class="col-sm-4"><a href="${pageContext.request.contextPath}/checkout" class="btn btn-success">Checkout</a></div>
			</div>
		</div>
	</div>
</div>
<br>
<%@include file="footer.jsp"  %>
</body>
</html>