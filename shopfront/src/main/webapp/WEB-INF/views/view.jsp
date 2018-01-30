<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="./resources/registercss.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>

</head>
<body>
<%@include file="header.jsp"  %>
<br><br><br>
<div class="col-sm-2"></div>
<div class = "col-sm-8" align="center" >
<h1>Suppliers List</h1>  
<table >  
<tr><th>Id</th><th>Name</th><th>Address</th><th>Contact Number</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="sup" items="${list}">   
   <tr>  
   <td>${sup.id}</td>  
   <td>${sup.name}</td>  
   <td>${sup.address}</td>
   <td>${sup.contactNum}</td>  
   <td><a href="#">Edit</a></td>  
   <td><a href="#">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>
   
   <br/>  <br/>
   <button type="submit" class="signupbtn">Add Supplier</button> 
</div>  
<%@include file="footer.jsp"  %>
</body>
</html>