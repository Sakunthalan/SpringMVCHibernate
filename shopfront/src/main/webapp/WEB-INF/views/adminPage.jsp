<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<%@include file="header.jsp"%>
	
<div class="container">
  <br><br><br><h3>Welcome</h3>
  <div class="col-md-8 col-md-offset-2">
  
  <ul class="nav nav-pills nav-justified">
    <li class="active"><a data-toggle="pill" href="#prod">Product</a></li>
    <li><a data-toggle="pill" href="#cat">Category</a></li>
    <li><a data-toggle="pill" href="#sup">Supplier</a></li>    
</ul>
<div class="tab-content">
    <div id="prod" class="tab-pane fade in active"><br><br>
		<form:form class="form-horizontal" id="login-form" method="post" action="saveProduct">
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="pid">Product ID:</label>		
    			<div class="col-sm-6"><input type="text" name="pid" id="pid" class="form-control" value=""></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="pname">Product Name: </label>
				<div class="col-sm-6"><input type="text" name="pname" id="pname" class="form-control" value=""></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">ok</button></div>
				<div class="col-sm-4"><button type="submit" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>    
	</div>
    <div id="cat" class="tab-pane fade"><br><br>
    	<form:form class="form-horizontal" id="login-form" method="post" action="saveCategory">
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="cid">Category ID:</label>		
    			<div class="col-sm-6"><input type="text" name="cid" id="cid" class="form-control" value=""></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="cname">Category Name: </label>
				<div class="col-sm-6"><input type="text" name="cname" id="cname" class="form-control" value=""></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">ok</button></div>
				<div class="col-sm-4"><button type="submit" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>    		 
    </div>
    <div id="sup" class="tab-pane fade"><br><br>
    	<form:form class="form-horizontal" id="login-form" method="post" action="saveSupplier">
			<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sid">Supplier ID:</label>		
    			<div class="col-sm-6"><input type="text" name="sid" id="sid" class="form-control" value=""></div>
    		</div></div><br>
    		<div class="row">
			<div class="form-group">
				<label class="control-label col-sm-4" for="sname">Supplier Name: </label>
				<div class="col-sm-6"><input type="text" name="sname" id="sname" class="form-control" value=""></div>
			</div></div><br>
			<div class="row">
			<div class="form-group">
				<div class="col-sm-4 col-sm-offset-3"><button type="submit" class="btn btn-login">ok</button></div>
				<div class="col-sm-4"><button type="submit" class="btn btn-login">Cancel</button></div>
			</div></div>		
		</form:form>   
    </div>    
  </div>
</div>
</div>
<br>
	<%@include file="footer.jsp"%>
</body>
</html>