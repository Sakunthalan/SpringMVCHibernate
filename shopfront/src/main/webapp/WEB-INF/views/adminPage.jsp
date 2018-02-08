<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminPage</title>
<link	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"	rel="stylesheet" type="text/css" />
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/admin.css">
</head>
<body>

<%-- <div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
  
  	<div class="navbar-header">
  	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"data-target="#bs-navbar-collapse">
  	<span class="sr-only"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	
  	</button>
  	<a class="navbar-brand" href="#">Shoppify</a>
  	<a class="navbar-brand" href="adminPage">Admin</a>  	
  	</div>
    
    <div class="collapse navbar-collapse" id="bs-navbar-collapse">
      <ul class="nav navbar-nav navbar-right mr-auto">
      	<li>
        	<a class = "navbar-brand" ><c:if test="${pageContext.request.userPrincipal.name != null}">
			<h4>Welcome : ${pageContext.request.userPrincipal.name}</h4> </c:if></a>
        </li>
        <li><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
        <li><a href="logout"> Logout</a></li>        
      </ul>
    </div>
  </div>
</div> --%>

<%@include file="header.jsp"%>
	<br/>
	
<div class="container">
  <br><br>
  <div class="col-md-8 col-md-offset-2">
  
  <ul class="nav nav-pills nav-justified">
    <li class="active"><a data-toggle="pill" href="#cat"><b>CATEGORY</b></a></li>
    <li><a data-toggle="pill" href="#sup"><b>SUPPLIER</b></a></li>
    <li><a data-toggle="pill" href="#prod"><b>PRODUCT</b></a></li>    
</ul>
<div class="tab-content">
    
    <div id="cat" class="tab-pane fade in active"><br><br>
    	<form:form class="form-horizontal" id="login-form" action="saveCategory" >
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="cid">Category ID:</label>		
    			<div class="col-sm-6"><input type="text" name="cid" class="form-control" value=""></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="cname">Category Name: </label>
				<div class="col-sm-6"><input type="text" name="cname" class="form-control" value=""></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">Save</button></div>
				<div class="col-sm-4"><button type="reset" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>    		 
    </div>
    <div id="sup" class="tab-pane fade"><br><br>
    	<form:form class="form-horizontal" id="login-form" method="post" action="saveSupplier" >
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sid">Supplier ID:</label>		
    			<div class="col-sm-6"><input type="text" name="sid" class="form-control" value=""></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sname">Supplier Name: </label>
				<div class="col-sm-6"><input type="text" name="sname" class="form-control" value=""></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">Save</button></div>
				<div class="col-sm-4"><button type="reset" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>   
    </div> 
    <div id="prod" class="tab-pane fade"><br><br>
		<form:form class="form-horizontal" method="post" action="saveProduct" enctype="multipart/form-data">
			<div class = "col-sm-10 col-sm-offset-2"><table>    
         	<tr>    
          		<td><b>Product Name</b></td><td><input type="text" name="prodname" class="form-control" value=""></td>  
        	</tr>    
         	<tr>    
         		<td><b>Product Price</b></td><td><input type="text" name="prodprice" class="form-control" value=""></td>  
         	</tr>   
         	<tr>    
          		<td><b>Product Description</b></td><td><input type="text" name="proddesc" class="form-control" value=""></td>  
         	</tr>   
            <tr>    
         		<td><b>Product Stock</b></td><td><input type="text" name="prodstock" class="form-control" value=""></td>  
         	</tr>
         	
         	<tr>
         		<td><b>Select Category</b></td>
         		<td><select class="form-control" id="categoryId" name="prodCategory" required>
         		<option value="">--Category--</option>
         		<c:forEach var="cat" items="${clist}">
         		<option value="${cat.categoryId}">${cat.categoryName}</option>
         		</c:forEach>         			
         		</select></td>
         	</tr>
           	<tr>
         		<td><b>Select Supplier</b></td>
         		<td><select class="form-control" name="prodSupplier" required>
         		<option value="">--Supplier--</option>
         		<c:forEach var="sup" items="${slist}">
         		<option value="${sup.supplierId}">${sup.supplierName}</option>
         		</c:forEach>		
         		</select></td>
         	</tr>  
         	<tr>
         		<td><b>Choose Image</b></td><td><input type="file" value="Browse" name="file"></td>
         	</tr>
        </table><br>
        <div class="form-group">
				<div class="col-sm-6"><button type="submit" class="btn btn-login">Save</button></div>
				<div class="col-sm-6"><button type="reset" class="btn btn-login">Cancel</button></div>
			</div>
        </div>  	
		</form:form>  
	</div>  
						
	</div>
</div>
<div class="col-sm-4 col-sm-offset-5"><a href="view" class="button btn btn-login">View All</a></div>
</div>
<br>
	<%@include file="footer.jsp"%>
</body>
</html>

