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
<jsp:include page="navbarUser.jsp" />
<br>
<br>
<br>
	<table class="table table-hover">
		<tr>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>Shop_no.</th>
			<th>Street Name</th>
			<th>City</th>
			<th>Pin Code</th>
			<th>Username</th>
			<th>Phone No.</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${alluser}" var="usr">
			<tr>
				<td>${usr.getFname()}</td>
				<td>${usr.getMname()}</td>
				<td>${usr.getLname()}</td>
				<td>${usr.getSno()}</td>
				<td>${usr.getStreetname()}</td>
				<td>${usr.getCity()}</td>
				<td>${usr.getPin()}</td>
				<td>${usr.getUsername()}</td>
				<td>${usr.getPno()}</td>
				<td>${usr.getMail()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

