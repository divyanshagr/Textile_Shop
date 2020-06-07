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
			<th>Payment Log ID</th>
			<th>EMPLOYEE ID</th>
			<th>MANUFACTURER ID</th>
			<th>PAYMENT TO</th>
			<th>AMOUNT</th>
			<th>Date of Payment</th>
		</tr>
		<c:forEach items="${allpay}" var="pay">
			<tr>
				<td>${pay.getPayid()}</td>
				<td>${pay.getEmp_id()}</td>
				<td>${pay.getMan_id()}</td>
				<td>${pay.getPtype()}</td>
				<td>${pay.getAmount()}</td>
				<td>${pay.getDop()}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

