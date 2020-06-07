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
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Last Name</th>
			<th>House No.</th>
			<th>Street Name</th>
			<th>City</th>
			<th>Salary</th>
			<th>Pin Code</th>
			<th>Phone No.</th>
		</tr>
		<c:forEach items="${allemp}" var="emp">
			<tr>
				<td>${emp.getFname()}</td>
				<td>${emp.getMname()}</td>
				<td>${emp.getLname()}</td>
				<td>${emp.getHno()}</td>
				<td>${emp.getStreetname()}</td>
				<td>${emp.getCity()}</td>
				<td>${emp.getSalary()}</td>
				<td>${emp.getPin()}</td>
				<td>${emp.getPno()}</td>
				<td><a
					href="/OnlineSite/admin/showemp/delete/${emp.getUsername()}">
						Delete</a></td>
				<td><a
					href="/OnlineSite/admin/showemp/update?user=${emp.getUsername()}">
						Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

