<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<jsp:include page="navbaradmin.jsp" />
	<br>
	<br>
	<br>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	<table class="table table-hover"><tr><th>Manage Products</th><td><h4>
			<a href="/OnlineSite/admin/prodadd">Add Products</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/showprod">Display All Products</a>
		</h4></td>
		</tr>
		<tr>
		<th>Manage Employees</th><td><h4>
			<a href="/OnlineSite/admin/empregister">Add employee</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/showemp">Display All Employee</a>
		</h4></td>
		</tr>
		<tr><th>Manage Manufacturers</th>
		<td><h4>
			<a href="/OnlineSite/admin/manregister">Add manufacturer</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/showmanufac">Display all Manufacturer</a>
		</h4></td>
		</tr>
		<tr><th>Manage Transporters</th>
		<td><h4>
			<a href="/OnlineSite/admin/transadd">Add Transporter</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/disptrans">Display all Transporter</a>
		</h4></td>
		</tr>
		<tr><th>Manage Godowns</th>
		<td><h4>
			<a href="/OnlineSite/admin/godownadd">Add Godown</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/dispgodown">Display All Godowns</a>
		</h4>
		</td>
		</tr>
		<tr><th>Manage Orders</th>
		<td><h4>
			<a href="/OnlineSite/admin/disptransnot">Orders not delivered</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/disptransyes">Orders delivered</a>
		</h4></td>
		</tr>
		<tr><th>Payments</th>
		<td><h4>
			<a href="/OnlineSite/admin/payemp">Pay To Employee</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/payman">Pay To Manufacturer</a>
		</h4></td>
		<td><h4>
			<a href="/OnlineSite/admin/showlog">Payment
				Log</a>
		</h4></td>
		</tr>
		<tr><th>Invoices</th>
		<td><h4>
			<a href="/OnlineSite/admin/dispinvoice">All Invoices</a>
		</h4></td>
		</tr>
		</table>
	</c:if>
</body>
</html>
