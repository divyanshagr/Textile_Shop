<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navbaradmin.jsp" />
<br>
<br>
<br>
	<form:form method="post" modelAttribute="employee" action="empregister">
		<table class="table table-hover"><tr><td>
		username</td><td>
		<form:input required="required" path="username" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="username" /></td></tr>
		
		<tr><td>
		password</td><td>
		<form:input required="required" path="password" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="password" /></td></tr>
		
		<tr><td>Confirm password</td>
		<td>
		<form:input required="required" path="mpassword" type="password" /> </td><!-- bind to user.name-->
		<td><form:errors path="mpassword" /></td></tr>
		
		<tr><td>First Name</td>
		<td>
		<form:input required="required" path="fname" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="fname" /></td></tr>
		
		<tr><td>Middle Name</td>
		<td>
		<form:input path="mname" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="mname" /></td></tr>
		
		<tr><td>Last Name</td>
		<td>
		<form:input path="lname" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="lname" /></td></tr>
		
		<tr><td>Phone No.</td>
		<td>
		<form:input required="required" path="pno" type="number" max="9999999999" min="1000000000"/> </td><!-- bind to user.name-->
		<td><form:errors path="pno" /></td></tr>
		<tr><td>House No.</td>
		<td>
		<form:input path="hno" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="hno" /></td></tr>
		
		<tr><td>Street Name</td>
		<td>
		<form:input path="streetname" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="streetname" /></td></tr>
		
		<tr><td>City</td>
		<td>
		<form:input path="city" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="city" /></td></tr>
		
		<tr><td>PIN</td>
		<td>
		<form:input path="pin" type="number" min="100000" max="999999" /> </td><!-- bind to user.name-->
		<td><form:errors path="pin" /></td></tr>
		
		<tr><td>Salary</td>
		<td>
		<form:input required="required" path="salary" type="number" min="0" /> </td><!-- bind to user.name-->
		<td><form:errors path="salary" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>