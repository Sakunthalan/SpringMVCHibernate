<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./resources/registercss.css">

</head>
<body>
<%@include file="header.jsp" %>
<br><br>

	<form:form class="form-horizontal" method="post" action="register" style="border:1px solid #ccc" >
		<div class="container"><br><br>
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>UserName:</b></label>		
    		<div class="col-sm-4"><input type="text" name="userName" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>Email:</b></label>		
    		<div class="col-sm-4"><input type="text" name="email" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>Password:</b></label>		
    		<div class="col-sm-4"><input type="password" name="password" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>Mobile:</b></label>		
    		<div class="col-sm-4"><input type="text" name="mobile" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>Address:</b></label>		
    		<div class="col-sm-4"><input type="text" name="address" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
			<label class="control-label col-sm-5"><b>Country:</b></label>		
    		<div class="col-sm-4"><input type="text" name="country" class="form-control" value=""></div>
    		<div class="col-sm-3"></div></div>
    		
    		<div class="form-group">
    		<div class="col-sm-2"></div>
			<div class="col-sm-5"><button type="submit" class="signupbtn">Register</button></div>
    		<div class="col-sm-5"><button type="submit" class="signupbtn">Cancel</button></div>
    		</div>
    		<br>
		</div>
	</form:form>

<%@include file="footer.jsp"  %>
<br>

</body>
</html>