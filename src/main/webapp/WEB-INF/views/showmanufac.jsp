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
			<th>Website</th>
			<th>Shop No.</th>
			<th>Street Name</th>
			<th>City</th>
			<th>Pin Code</th>
			<th>Phone No.</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${allmanufac}" var="manufac">
			<tr>
				<td>${manufac.getName()}</td>
				<td>${manufac.getWebsite()}</td>
				<td>${manufac.getSno()}</td>
				<td>${manufac.getStreetname()}</td>
				<td>${manufac.getCity()}</td>
				<td>${manufac.getPin()}</td>
				<td>${manufac.getPno()}</td>
				<td>${manufac.getMail()}</td>
				<td><a
					href="/OnlineSite/admin/showmanufac/delete/${manufac.getName()}">
						Delete</a></td>
				<td><a
					href="/OnlineSite/admin/showmanufac/update?user=${manufac.getName()}">
						Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

