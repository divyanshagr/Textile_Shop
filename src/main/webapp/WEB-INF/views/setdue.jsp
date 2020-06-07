<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<jsp:include page="navbaradmin.jsp" />
				<br>
				<br>
				<br>

			</c:when>
			<c:otherwise>
				<jsp:include page="navbarempl.jsp" />
				<br>
				<br>
				<br>

			</c:otherwise>
		</c:choose>
	<form:form method="post" modelAttribute="transportentry" action="setdue">
		<table class="table table-hover"><tr><td>Transporter ID</td>
		<td>
		<form:select path="tid">
		<c:if test="${!empty alltrans}">
		<c:forEach items="${alltrans}" var="trans" varStatus="loop">
		<form:option value="${trans.getTid()}">${trans.getTid()}(${trans.getName()})</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="tid" /></td>
		</tr>
		<tr><td>Date Of Transportation</td>
		<td>
		<form:input required="required" path="dot" type="date" /> </td><!-- bind to user.name-->
		<td><form:errors path="dot" /></td></tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	<form:hidden path="inv_id" value="${inv_id}"/>
	</form:form>