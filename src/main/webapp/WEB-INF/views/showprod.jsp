<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<jsp:include page="navbaradmin.jsp" />
				<br>
				<br>
				<br>

			</c:when>
			<c:otherwise>
				<jsp:include page="navbarempl.jsp" />
				<br>
				<br>
				<br>

			</c:otherwise>
		</c:choose>
<table class="table table-hover">
<tr>
    <th>Name</th>
    <th>Manufacturer ID</th>
    <th>Cloth Type</th>
    <th>Color</th>
    <th>Buy Price</th>
    <th>Sell Price</th>
    <th>Quantity</th>
</tr>
<c:forEach items="${allprod}" var="products">
    <tr>
        <td>${products.getName()}</td>
        <td>${products.getMid()}</td>
        <td>${products.getCtype()}</td>
        <td>${products.getColor()}</td>
        <td>${products.getBprice()}</td>
        <td>${products.getSprice()}</td>
        <td>${products.getQuantity()}</td>
        <c:choose>
        	<c:when test="${role=='ROLE_ADMIN'}">
        		<td><a href="/OnlineSite/admin/showprod/delete/${products.getProduct_id()}"> Delete</a> 
        		</td>
         		<td><a href="/OnlineSite/admin/showprod/update?name=${products.getProduct_id()}"> Update</a></td> 
        		</c:when>
        	<c:otherwise>
        		<td><a href="/OnlineSite/empl/showprod/delete/${products.getProduct_id()}"> Delete</a> 
        		<td><a href="/OnlineSite/empl/showprod/update?name=${products.getProduct_id()}"> Update</a></td> 
        	</c:otherwise>
        </c:choose>
    </tr>
</c:forEach>
</table>
</body>
</html>

