<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link rel="stylesheet" href="./resources/registercss.css">

<title>Add Supplier</title>
</head>
<body>
<%@include file="header.jsp"  %>

<br><br>

<form action="add" method ="post" style="border:1px solid #ccc">
  <div class="container">
  <br><br>
    <h2>Add Suppliers</h2>
   
    <hr>

    <label><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>

    <label><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="address" required>
    
    <label><b>Contact Number</b></label>
    <input type="text" placeholder="Contact Number" name="contactNum" required>
  
<br>

    <div class="clearfix">
           <button type="submit" class="signupbtn">Add</button>
    </div>
    <br>
  </div>
</form>

<%@include file="footer.jsp"  %>
</body>
</html>