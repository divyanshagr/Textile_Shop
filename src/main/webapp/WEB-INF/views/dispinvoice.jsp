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
			<th>Invoice ID</th>
			<th>Generated To</th>
			<th>Amount</th>
			<th>Date Of Generation</th>
		</tr>
		<c:forEach items="${allinv}" var="inv">
			<tr>
				<td>${inv.getInv_id()}</td>
				<td>${inv.getUsername()}</td>
				<td>${inv.getAmount()}</td>
				<td>${inv.getDog()}</td>
				<td><a href="/OnlineSite/admin/dispinvoice/invoicedetail?id=${inv.getInv_id()}">Details</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>

