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
	<th>Invoice No.</th>
	<th>Address</th>
	<th>City</th>
	<th>Pincode</th>
	<th>Phone No.</th>
	<th>Transporter ID</th>
	<th>Date Of Transportaion</th>
</tr>
<c:forEach items="${allentry}" var="ent">
	<tr>
		<td>${ent.getInv_id()}</td>
		<td>${ent.getAddress()}</td>
		<td>${ent.getCity()}</td>
		<td>${ent.getPincode()}</td>
		<td>${ent.getPhone_no()}</td>
		<td>${ent.getTid()}</td>
		<td>${ent.getDot()}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>