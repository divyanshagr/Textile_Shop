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
<jsp:include page="navbaradmin.jsp" />
<br>
<br>
<br>
	<table class="table table-hover">
		<tr>
			<th>Name</th>
			<th>Address</th>
			<th>City</th>
			<th>Pin Code</th>
			<th>Phone No.</th>
		</tr>
		<c:forEach items="${alltrans}" var="trans">
			<tr>
				<td>${trans.getName()}</td>
				<td>${trans.getAddress()}</td>
				<td>${trans.getCity()}</td>
				<td>${trans.getPincode()}</td>
				<td>${trans.getPhone_no()}</td>
				<td><a href="/OnlineSite/admin/disptrans/delete/${trans.getTid()}">
				Delete</a></td>
				<td><a href="/OnlineSite/admin/disptrans/update?trans=${trans.getTid()}"> Update</a></td> 
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>

