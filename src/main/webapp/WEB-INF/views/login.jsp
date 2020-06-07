<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
}
</style>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<jsp:include page="navbarhome.jsp" />
	<br>
	<br>
	<br>
	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("<span class=\"errorblock\">Incorrect login name or password. Please try again");
		}
	%>

	<form name='loginForm' action="<c:url value='login' />" method='POST'>

		<table class="table table-hover">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td></td>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>

	</form>
</body>
</html>