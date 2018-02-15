<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title> HOME </title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="navbar navbar-default navbar-fixed-top">
  <div class="container">
  
  	<div class="navbar-header">
  	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"data-target="#bs-navbar-collapse">
  	<span class="sr-only"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	<span class="icon-bar"></span>
  	
  	</button>
 	<a class="navbar-brand" href="#"><b>Shoppify</b></a>
  	</div>
    
    <div class="collapse navbar-collapse" id="bs-navbar-collapse">
    	 <ul class="nav navbar-nav navbar-left mr-auto">
      		<li><a href="${pageContext.request.contextPath}/admin/adminPage"><b>Admin</b></a></li>
     		<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><b>Category</b><span class="caret"></span></a>
        		<ul class="dropdown-menu">
        		<c:forEach var="cat" items="${clist}">
        		<%-- <li><a href="custProductList?categoryId=${cat.categoryId}">${cat.categoryName}</a></li> --%>
        		<c:if test="${pageContext.request.userPrincipal.name == null}">
		        	<li><a href="login">${cat.categoryName}</a></li>
		        </c:if>
		        <c:if test="${pageContext.request.userPrincipal.name != null}">
		        	<li><a href="custProductList?categoryId=${cat.categoryId}">${cat.categoryName}</a></li>
		        </c:if>
         		</c:forEach> 
        		</ul>
      		</li>
      		<li><a href="${pageContext.request.contextPath}/admin/adminProductList"><b>Admin List</b></a></li>
    	</ul> 
      <ul class="nav navbar-nav navbar-right mr-auto">
      	<c:if test="${pageContext.request.userPrincipal.name == null}">
        	<li><a href="home"><span class="glyphicon glyphicon-home"></span><b> Home</b></a></li>
        	<li><a href="register"><b>Register</b></a></li>
        	<li><a href="login"><span class="glyphicon glyphicon-log-in"></span><b> Login</b></a></li>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
      		<li> <a><b>Welcome : ${pageContext.request.userPrincipal.name} </b></a></li>
      		<li><a href="${pageContext.request.contextPath}/cart"><span class="glyphicon glyphicon-shopping-cart"></span> <b>My Cart</b></a></li>
<!--         	<li><a href="home"><span class="glyphicon glyphicon-home"></span><b> Home</b></a></li>
 -->        	<li><a href="<c:url value="/logout"/>"><b>Logout</b></a></li>  
        </c:if>  
        
      </ul>
    </div>
  </div>
</div>

</body>
</html>