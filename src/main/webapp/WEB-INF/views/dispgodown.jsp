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
	<th>Shop No.</th>
	<th>Street Name</th>
	<th>City</th>
	<th>Pincode</th>
</tr>
<c:forEach items="${allgodown}" var="god">
	<tr>
		<td>${god.getShop_no()}</td>
		<td>${god.getStreet_name()}</td>
		<td>${god.getCity()}</td>
		<td>${god.getPincode()}</td>
		<td><a href="/OnlineSite/admin/dispgodown/delete/${god.getGid()}">Delete</a></td>
		<td><a href="/OnlineSite/admin/dispgodown/update?godown=${god.getGid()}">Update</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>