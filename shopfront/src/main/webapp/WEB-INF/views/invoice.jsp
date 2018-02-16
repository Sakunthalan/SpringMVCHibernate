<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "javax.servlet.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invoice</title>
<style>
body {
    background-image:    url(./resources/tulips.jpg);
    background-size:     cover;                      /* <------ */
    background-repeat:   no-repeat;
    background-position: center center;              /* optional, center the image */    
}
</style>
</head>
<body>
<%@include file="header.jsp"%>
<br><br><br><br><br>
<div class="container">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
	<div class="panel-group">
		<div class="panel panel-default col-sm-12">
		<div class="panel-heading"><h2>Invoice</h2></div>
		<div class="panel-body">
			<div class="row">
    			<div class="col-xs-6">
    				<address>
    				<strong>Billed To:</strong><br>
    					${user.userName}<br>
    					${user.address}<br>
    					${user.country}<br>
    					${user.mobile}
    				</address>
    			</div>
    			<div class="col-xs-6 text-right">
    				<address>
        			<strong>Order Date:</strong><br>
    					<% Date dNow = new Date( );
         					SimpleDateFormat ft = new SimpleDateFormat ("E dd.MM.yyyy 'at' hh:mm a");
       						out.print(ft.format(dNow));
     					%><br>
    				</address>
    				<strong>Payment Method</strong><br>
    				${payment}<br>
    				<br>
    				<strong>Total Amount</strong><br>
    				${total}<br>
    				<br>
    			</div>
    		</div>
			<div class="row col-sm-8 col-sm-offset-2" align="center">
			<a href="${pageContext.request.contextPath}/thanks" class="btn btn-success">Confirm</a>
			</div>
		</div></div>
	</div></div>
	
</div>
<br>
<%@include file="footer.jsp"%>
</body>
</html>