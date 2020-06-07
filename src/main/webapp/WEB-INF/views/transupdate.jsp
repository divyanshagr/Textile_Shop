<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbaradmin.jsp" />
<br>
<br>
<br>

<form:form method="post" modelAttribute="transporter" action="update">
	<table class="table table-hover">
		<tr>
			<td>Name</td>
			<td><form:input required="required" path="name" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="name" /></td>
		</tr>

		<tr>
			<td>Address</td>
			<td><form:input path="address" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="address" /></td>
		</tr>

		<tr>
			<td>City</td>
			<td><form:input path="city" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="city" /></td>
		</tr>

		<tr>
			<td>Pin Code</td>
			<td><form:input path="pincode" type="number" min="100000"
					max="999999" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="pincode" /></td>
		</tr>

		<tr>
			<td>Phone No.</td>
			<td><form:input required="required" path="phone_no"
					type="number" max="9999999999" min="1000000000" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="phone_no" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
			<td>${error}</td>
		</tr>
	</table>
	<form:hidden path="tid" value="${tid}" />
</form:form>