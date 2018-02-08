<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>

</head>
<body>

<%@include file="header.jsp"%>
	<br/>

<br><br>

<c:if test="${pageContext.request.userPrincipal.name == null}">
		<h2>
			Welcome 
		</h2>
	</c:if>

<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} to Shoppify...!
		</h2>
	</c:if>

<br>
<div class="col-sm-2 sidenav"></div>
<div class="col-sm-8">
 <img src="./resources/tulips.jpg" alt="tulips" style="width: 100%; height: 500px" /></div>
</body>
</html>