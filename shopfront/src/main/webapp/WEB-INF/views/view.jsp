<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="./resources/registercss.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page</title>

</head>
<body>
<%@include file="header.jsp"%>
	<br/> 
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
  			<h2>Category List</h2>
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
  			<h2>Category List</h2>
		</div>	
		</div>
	</div>
</div>
<div class="col-sm-2"></div>
<br>
<%@include file="footer.jsp"  %>
</body>
</html>