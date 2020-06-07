<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navbarhome.jsp" />
<br>
<br>
<br>
	<form:form method="post" modelAttribute="user" action="register">
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
		
		<tr><td>Shop No.</td>
		<td>
		<form:input path="sno" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="sno" /></td></tr>
		
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
		
		<tr><td>Email ID</td>
		<td>
		<form:input path="mail" type="email" /> </td><!-- bind to user.name-->
		<td><form:errors path="mail" /></td></tr>
		
		<tr><td>Phone No.</td>
		<td>
		<form:input required="required" path="pno" type="number" min="1000000000" max="9999999999" /> </td><!-- bind to user.name-->
		<td><form:errors path="pno" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>