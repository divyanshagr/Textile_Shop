<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <style>
      
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  height:300px;
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: left;
  font-weight: 500;
  font-size: 12px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: left;
  vertical-align:middle;
  font-weight: 300;
  font-size: 12px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}


/* demo styles */

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
body{
  background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;
}
section{
  margin: 50px;
}


/* follow me template */
.made-with-love {
  margin-top: 40px;
  padding: 10px;
  clear: left;
  text-align: center;
  font-size: 10px;
  font-family: arial;
  color: #fff;
}
.made-with-love i {
  font-style: normal;
  color: #F50057;
  font-size: 14px;
  position: relative;
  top: 2px;
}
.made-with-love a {
  color: #fff;
  text-decoration: none;
}
.made-with-love a:hover {
  text-decoration: underline;
}


/* for custom scrollbar for webkit browser*/

::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
    </style>
  
    

  
</head>

<body>
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
  <section>
  <div class="tbl-header">
    <table cellpadding="0" cellspacing="0" border="0">
      <thead>
        <tr>
         <th>Name</th>
    <th>Manufacured By</th>
    <th>Cloth Type</th>
    <th>Color</th>
    <th>Buy Price</th>
    <th>Sell Price</th>
    <th>Quantity</th>
	<th>Delete</th>
    <th>Update</th>
	    
        </tr>
      </thead>
    </table>
  </div>
  <div class="tbl-content">
    <table cellpadding="0" cellspacing="0" border="0">
      <tbody>
         <c:forEach items="${allprod}" var="products">
         <tr>
        <td>${products.getName()}</td>
        <td>${products.getMid()}</td>
        <td>${products.getCtype()}</td>
        <td>${products.getColor()}</td>
        <td>${products.getBprice()}</td>
        <td>${products.getSprice()}</td>
        <td>${products.getQuantity()}</td>
        <c:choose>
          <c:when test="${role=='ROLE_ADMIN'}">
            <td><a href="/OnlineSite/admin/showprod/delete/${products.getProduct_id()}"> Delete</a> 
            </td>
            <td><a href="/OnlineSite/admin/showprod/update?name=${products.getProduct_id()}"> Update</a></td> 
            </c:when>
          <c:otherwise>
            <td><a href="/OnlineSite/empl/showprod/delete/${products.getProduct_id()}"> Delete</a> 
            <td><a href="/OnlineSite/empl/showprod/update?name=${products.getProduct_id()}"> Update</a></td> 
          </c:otherwise>
        </c:choose>
        </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</section>

 <!-- <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

 <script >
$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize();
  </script>-->

</body>

</html>
