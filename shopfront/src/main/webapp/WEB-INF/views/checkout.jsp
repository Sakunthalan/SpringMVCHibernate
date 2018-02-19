<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>

</head>
<body background="./resources/back2.jpg">
<%@include file="header.jsp"%>
<br>	<br>	<br><br><br>
<div class="container">
	<div class="col-sm-2"></div>
	<div class="col-sm-8">
		<div class="panel-group">
		<div class="panel panel-default col-sm-12">
			<div class="panel-heading"></div>
			<c:forEach var="cart" items="${cart}"></c:forEach>
			<div class="panel-body col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><h4>Customer Details</h4></div>
					<div class="panel-body">
					<table>
						<tr><td><b>Name </b> ${user.userName}</td></tr>
						<tr><td><b>Email </b>${user.email }</td></tr>
						<tr><td><b>Mobile </b>${user.mobile }</td></tr>
						<tr><td><b>Address </b>${user.address }</td></tr>
						<tr><td><b>Total Amount </b>${cart.stream().map(cart -> cart.cartPrice * cart.quantity).sum()}</td></tr>
					</table>
					</div>
				</div>				
			</div>
			<div class="panel-body col-sm-6">
				<div class="panel panel-default">
					<div class="panel-heading"><h4>Enter Card Details</h4></div>
					<div class="panel-body">
						<div class="col-sm-9 col-sm-offset-1"><form:form method="post" action="${pageContext.request.contextPath}/invoice">
						Payment
						<select class="form-control" name="payment" required>
						<option value="">--Select Payment--</option>
         				<option value="Cash on Delivery">Cash on Delivery</option>
         		        <option value="Net Banking">Net Banking</option></select>
         		        <input required type="hidden" name="total" class="form-control" value="${cart.stream().map(cart -> cart.cartPrice * cart.quantity).sum()}">
         		        <input required type="text" name="cardnumber" class="form-control" value="" placeholder="Enter your card number">
         		        <input required type="text" name="cardname" class="form-control" value="" placeholder="Name on card">
         		        <input required type="text" name="cvv" class="form-control" value="" placeholder="CVV">
         		        Expiry
         		        <div class="row"><div class="col-sm-6"><input required type="number" name="month" class="form-control" value="" placeholder="mm" maxlength="2"></div>
         		        <div class="col-sm-6"><input required type="number" name="year" class="form-control" value="" placeholder="yy" maxlength="4"></div></div><br>
         		        <button type="submit" class="btn btn-success"> Place Order</button></form:form>
         		        </div>         		        
					</div>
				</div>
			</div>
		</div>		
		</div>
	</div>
</div>
<br>
<%@include file="footer.jsp"%>
</body>
</html>