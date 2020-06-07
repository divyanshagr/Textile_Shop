<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<jsp:include page="navbarhome.jsp" />
	<br>
	<br>
	<br>
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
		<td>
        <div class="w3-container">
  			<a href="/OnlineSite/login" class="w3-button w3-black">Add to Cart</a>
			</div>
			</td>
     </tr>
</c:forEach>
</table>
</body>
</html>