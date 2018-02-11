<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Admin Manage Products</title>
<style>
.search-container {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

</style>
</head>
<body>
<%@include file="header.jsp"%>
	<br><br><br>
<div class="container">
	<div class="col-sm-1"></div>
	<div class = "col-sm-10" align="center">
		<br>
		<div class ="row"><div class="col-sm-6">		
		<h3><b>Product List</b></h3></div>
		<div class="col-sm-6"><div class="search-container">
			<form>
      		<input type="text" placeholder="Search.." name="search">
      		<button type="submit"><i class="fa fa-search"></i></button>
    		</form>
  		</div></div></div><br>
		<table class="table table-striped" border="1">
			<thead>
				<tr>
					<th>Product Id</th>
					<th>Product Name</th>
					<th>Product Description</th>
					<th>Category</th>
					<th>Supplier</th>
					<th>Product Price</th>
					<th>Product Stock</th>
					<th>Product Image</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="prod" items="${prodList}">
					<tr>
						<td>${prod.pid}</td>
						<td>${prod.pname}</td>
						<td>${prod.description}</td>
						<td>${prod.category.categoryName}</td>
						<td>${prod.supplier.supplierName}</td>
						<td>${prod.price}</td>
						<td>${prod.stock}</td>
						<td><img src="./resources/${prod.imgName}" width="50" height="50" /></td>
						<td><div class="row"><div class="col-sm-5"><a href="updateProduct?pid=${prod.pid}" class="btn btn-info"><span class="glyphicon glyphicon-pencil"></span> </a></div>
							<div class="col-sm-5"><a href="#" class="btn btn-info"><span class="glyphicon glyphicon-trash"></span> </a></div></div></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-sm-1"></div>
</div>
	
<br>
<%@include file="footer.jsp"  %>
</body>
</html>