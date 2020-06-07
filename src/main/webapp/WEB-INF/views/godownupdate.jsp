<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbaradmin.jsp" />
<br>
<br>
<br>

<form:form method="post" modelAttribute="godown" action="update">
	<table class="table table-hover">
		<tr>
			<td>Shop No.</td>
			<td><form:input required="required" path="shop_no" type="text" />
			</td>
			<!-- bind to user.name-->
			<td><form:errors path="shop_no" /></td>
		</tr>

		<tr>
			<td>Street Name</td>
			<td><form:input required="required" path="street_name"
					type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="street_name" /></td>
		</tr>

		<tr>
			<td>City</td>
			<td><form:input required="required" path="city" type="text" />
			</td>
			<!-- bind to user.name-->
			<td><form:errors path="city" /></td>
		</tr>


		<tr>
			<td>Pincode</td>
			<td><form:input path="pincode" type="number" min="100000"
					max="999999" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="pincode" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
			<td>${error}</td>
		</tr>
	</table>
	<form:hidden path="gid" value="${gid}" />
</form:form>