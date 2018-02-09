<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Products</title>

</head>
<body>
<%@include file="header.jsp"%>
	<br><br><br><br>
<div class="container">
	<div class="col-sm-2"></div>
	<div class = "col-sm-8" align="center">
		<br>
		<br>
		<h3>Product List</h3>
		<table class="table table-striped" border="1">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Category</th>
					<th>Product Price</th>
					<th>Product Stock</th>
					<th>Product Image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${prodList}">
					<tr>
						<td>${prod.pid}</td>
						<td>${prod.pname}</td>
						<td>${prod.description}</td>
						<td>${prod.category.categoryName}</td>
						<td>${prod.price}</td>
						<td>${prod.stock}</td>
						<td><img src="./resources/${prod.imgName}" width="50" height="50" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<div class="col-sm-2"></div>
<br>
<%@include file="footer.jsp"  %>
</body>
</html>