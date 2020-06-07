<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="navbarUser.jsp" />
<br>
<br>
<br>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
    <table class="table table-hover">
    	<tr>
    <th>
        <div class="w3-container">
  			<a href="/OnlineSite/user/update" class="w3-button w3-black"> Edit Profile</a>
			</div>
        </th>
        <th>
        <div class="w3-container">
  			<a href="/OnlineSite/user/dispuser" class="w3-button w3-black"> Display Profile</a>
			</div>
        </th>
        <th>
        <div class="w3-container">
  			<a href="/OnlineSite/user/showcart" class="w3-button w3-black"> Go to Cart</a>
			</div>
        </th>
        </tr>
        </table>
    </c:if>
  <table class="table table-hover">
<tr>
    <th>Name</th>
    <th>Manufacured By</th>
    <th>Cloth Type</th>
    <th>Color</th>
    <th>Price</th>
    <th>Quantity Available</th>
</tr>
<c:forEach items="${allprod}" var="products">
    <tr>
        <td>${products.getName()}</td>
        <td>${products.getMid()}</td>
        <td>${products.getCtype()}</td>
        <td>${products.getColor()}</td>
        <td>${products.getSprice()}</td>
        <td>${products.getQuantity()}</td>
        <c:choose>
        	<c:when test="${products.getQuantity()==0}">
        	<td>Out Of Stock</td>
        	</c:when>
        	<c:otherwise>
        	<td>
        	<div class="w3-container">
  			<a href="/OnlineSite/user/cart?username=${user}&pid=${products.getProduct_id()}" class="w3-button w3-black">Add to Cart</a>
			</div>
			</td>
        	</c:otherwise>
        </c:choose>
        
     </tr>
</c:forEach>
</table>
</body>
</html>
