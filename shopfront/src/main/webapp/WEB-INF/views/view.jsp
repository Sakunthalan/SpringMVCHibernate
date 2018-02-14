<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false" %>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View Page</title>

</head>
<body>
<%@include file="header.jsp"%>
	<br><br><br><br>
<div class="container">
	<div class="col-sm-2"></div>
	<div class = "col-sm-8" align="center">
		<ul class="nav nav-pills nav-justified">
    	<li class="active"><a data-toggle="pill" href="#cat"><b>CATEGORY</b></a></li>
    	<li><a data-toggle="pill" href="#sup"><b>SUPPLIER</b></a></li>
    	<li><a data-toggle="pill" href="#prod"><b>PRODUCT</b></a></li>    
		</ul>
		
		<div class="tab-content">
		
        <div id="cat" class="tab-pane fade in active"><br><br>
  			<h3>Category List</h3>
			<table class="table table-striped" border="1">
   			<thead>
      			<tr>
        			<th>Category Id</th>
        			<th>Category Name</th>
      			</tr>
    		</thead>
    		<tbody>
    		<c:forEach var="cat" items="${clist}">
      			<tr>
        			<td>${cat.categoryId}</td>  
   					<td>${cat.categoryName}</td>
      			</tr>
      		</c:forEach>
      		</tbody>
  			</table>
		</div>		
		<div id="sup" class="tab-pane fade"><br><br>
  			<h3>Supplier List</h3>
  			<table class="table table-striped" border="1">
   			<thead>
      			<tr>
        			<th>Supplier Id</th>
        			<th>Supplier Name</th>
      			</tr>
    		</thead>
    		<tbody>
    		<c:forEach var="sup" items="${slist}">
      			<tr>
        			<td>${sup.supplierId}</td>  
   					<td>${sup.supplierName}</td>
      			</tr>
      		</c:forEach>
      		</tbody>
  			</table>
		</div>	
		<div id="prod" class="tab-pane fade"><br><br>
  			<h3>Product List</h3>
  			<table class="table table-striped" border="1">
   			<thead>
      			<tr>
        			<th>Product Id</th>
        			<th>Product Name</th>
        			<th>Product Description</th>
        			<th>Product Price</th>
        			<th>Product Stock</th>
        			<th>Product Image</th>
      			</tr>
    		</thead>
    		<tbody>
    		<c:forEach var="prod" items="${plist}">
      			<tr>
        			<td>${prod.pid}</td>  
   					<td>${prod.pname}</td>
   					<td>${prod.description}</td>
   					<td>${prod.price}</td>
   					<td>${prod.stock}</td>
   					<td><img src="../resources/${prod.imgName}" width="50" height="50"/></td>
      			</tr>
      		</c:forEach>
      		</tbody>
  			</table>
		</div>
		</div>
 	</div>
</div>
<div class="col-sm-2"></div>
<br>
<%@include file="footer.jsp"  %>
</body>
</html>