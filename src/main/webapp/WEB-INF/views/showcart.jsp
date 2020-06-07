<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="navbarUser.jsp" />
<br>
<br>
<br>
<c:choose>
<c:when test="${cartsize==0}">
	<h2>Cart Empty!!</h2>
</c:when>
<c:otherwise>
<table class="table table-hover">
<tr>
    <th>Name</th>
    <th>Quantity</th>
    <th>Maximum Quantity Available</th>
    <th>Cloth Type</th>
    <th>Color</th>
    <th>Price</th>
</tr>
<c:forEach items="${allcart}" var="cart">
    <tr>
        <td>${cart.getName()}</td>
        <td>${cart.getQuantity()}</td>
        <td>${cart.getMaxquan()}</td>
        <td>${cart.getCtype()}</td>
        <td>${cart.getColor()}</td>
        <td>${cart.getPrice()}</td>
        <td>
        <div class="w3-container">
  			<a href="/OnlineSite/user/showcart/delete?pid=${cart.getPid()}" class="w3-button w3-black">Delete</a>
			</div></td>
         <td>
         <div class="w3-container">
  			<a href="/OnlineSite/user/showcart/update?pid=${cart.getPid()}" class="w3-button w3-black">Update</a>
			</div></td>
    </tr>
</c:forEach>
</table>
<h4>Cart Total :         Rs. ${price} </h4><br>
<h5>Please Select Appropriate Quantity</h5>
<h4>
 <div class="w3-container">
  			<a href="/OnlineSite/user/showcart/checkout" class="w3-button w3-black">Checkout</a>
			</div></h4>
</c:otherwise>
</c:choose>
</body>
</html>

