<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<jsp:include page="navbarempl.jsp" />
<br>
<br>
<br>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <h3>
        <a href="/OnlineSite/empl/prodadd">Click here to add products</a></h3>
        <h3>
        <a href="/OnlineSite/empl/showprod">Click here to see products</a></h3>
        <h3>
			<a href="/OnlineSite/empl/disptransnot">Click here to show orders not delivered</a>
		</h3>
		<h3>
			<a href="/OnlineSite/empl/disptransyes">Click here to show orders delivered</a>
		</h3>
    </c:if>
</body>
</html>