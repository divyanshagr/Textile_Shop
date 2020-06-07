<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navbarUser.jsp" />
<br>
<br>
<br>
<form:form method="post" modelAttribute="transportentry" action="checkout">
	<table class="table table-hover">
		<tr>
			<td>Address</td>
			<td><form:input required="required" path="address" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="address" /></td>
		</tr>

		<tr>
			<td>City</td>
			<td><form:input required="required" path="city" type="Text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="city" /></td>
		</tr>

		<tr>
			<td>Pin Code</td>
			<td><form:input required="required" path="pincode" type="number" min="100000" max="999999" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="pincode" /></td>
		</tr>

		<tr>
			<td>Phone No.</td>
			<td><form:input required="required" path="phone_no" type="number" min="1000000000" max="9999999999" /></td>
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
	<form:hidden path="username" value="${username}"/>
</form:form>