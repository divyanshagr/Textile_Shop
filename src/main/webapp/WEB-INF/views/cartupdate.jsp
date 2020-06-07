<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navbarUser.jsp" />
<br>
<br>
<br>
	<form:form method="post" modelAttribute="cart" action="update">
		<table class="table table-hover">
		<tr><td>
		Quantity</td><td>
		<form:input path="quantity" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="quantity" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
		<form:hidden path="username" value="${username}"/>
		<form:hidden path="pid" value="${pid}"/>
		<form:hidden path="maxquan" value="${maxquan}"/>
	</form:form>