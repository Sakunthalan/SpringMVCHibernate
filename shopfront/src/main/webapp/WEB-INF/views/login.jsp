<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="./resources/logincss.css">
<title>Login</title>
</head>
<body background="./resources/back.jpg">

<%@include file="header.jsp" %>

	<br/>
<div class="container">
<br><br><br><br>
    <div class="row">
    <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="form-login">
            <h4>Login</h4><form method="post" action="<c:url value='/j_spring_security_check'/>">
            <input type="text" name="username" class="form-control input-sm chat-input" placeholder="username" />
            <br>
            <input type="password" name="password" class="form-control input-sm chat-input" placeholder="password" />
            <br>
            <div class="wrapper">
            <span class="group-btn">  
            <button type="submit" class="btn btn-primary btn-md">LOGIN <i class="fa fa-sign-in"></i></button>   
            </span>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            </div>
        </div>
    </div>
</div>

<br>
	<%@include file="footer.jsp"%>
</body>
</html>


<!--Pulling Awesome Font -->


