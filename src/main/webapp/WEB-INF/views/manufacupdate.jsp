<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navbaradmin.jsp" />
<br>
<br>
<br>

<form:form method="post" modelAttribute="manufacturer" action="update">
	<table class="table table-hover">

		<tr>
			<td>Phone No.</td>
			<td><form:input required="required" path="pno" type="number"
					max="9999999999" min="1000000000" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="pno" /></td>
		</tr>

		<tr>
			<td>Email</td>
			<td><form:input required="required" path="mail" type="email" />
			</td>
			<!-- bind to user.name-->
			<td><form:errors path="mail" /></td>
		</tr>

		<tr>
			<td>Shop No.</td>
			<td><form:input path="sno" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="sno" /></td>
		</tr>

		<tr>
			<td>PIN</td>
			<td><form:input path="pin" type="number" max="999999"
					min="100000" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="pin" /></td>
		</tr>

		<tr>
			<td>City</td>
			<td><form:input path="city" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="city" /></td>
		</tr>

		<tr>
			<td>Street Name</td>
			<td><form:input path="streetname" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="streetname" /></td>
		</tr>

		<tr>
			<td>Website</td>
			<td><form:input path="website" type="text" /></td>
			<!-- bind to user.name-->
			<td><form:errors path="website" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
			<td>${error}</td>
		</tr>
	</table>
	<form:hidden path="name" value="${name}" />
</form:form>