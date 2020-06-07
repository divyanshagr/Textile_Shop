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
	<form:form method="post" modelAttribute="products" action="prodadd">
		<table class="table table-hover"><tr><td>
		Name</td><td>
		<form:input required="required" path="name" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="name" /></td></tr>
		
		<tr><td>Manufacturer ID</td>
		<td>
		<form:select path="mid">
		<c:if test="${!empty allmanufac}">
		<c:forEach items="${allmanufac}" var="man" varStatus="loop">
		<form:option value="${man.getMid()}">${man.getMid()}(${man.getName()})</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="mid" /></td>
		</tr>
		<tr><td>Godown ID</td>
		<td>
		<form:select path="gid">
		<c:if test="${!empty allgodown}">
		<c:forEach items="${allgodown}" var="god" varStatus="loop">
		<form:option value="${god.getGid()}">${god.getGid()}</form:option>
		</c:forEach>
		</c:if>
		</form:select>
		</td><!-- bind to user.name -->
		<td><form:errors path="gid" /></td>
		</tr>
		<tr><td>Cloth Type</td>
		<td>
		<form:input path="ctype" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="ctype" /></td></tr>
		
		<tr><td>Color</td>
		<td>
		<form:input path="color" type="text" /> </td><!-- bind to user.name-->
		<td><form:errors path="color" /></td></tr>
		
		<tr><td>Buy Price Rs.</td>
		<td>
		<form:input required="required" path="bprice" type="number" min="1" /> </td><!-- bind to user.name-->
		<td><form:errors path="bprice" /></td></tr>
		
		<tr><td>Sell Price Rs.</td>
		<td>
		<form:input required="required" path="sprice" type="number" min="1"/> </td><!-- bind to user.name-->
		<td><form:errors path="sprice" /></td></tr>
		
		<tr><td>Quantity Available</td>
		<td>
		<form:input required="required" path="quantity" type="number" min="0"/> </td><!-- bind to user.name-->
		<td><form:errors path="quantity" /></td></tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
			</tr>
		<tr><td>${error}</td></tr>
		</table>
	</form:form>