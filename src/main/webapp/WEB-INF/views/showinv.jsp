<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<style type="text/css">
		body {
  font-family: "Montserrat", sans-serif;
  font-weight: 400;
  color: #322d28;
}

header.top-bar h1 {
  font-family: "Montserrat", sans-serif;
}

main {
  margin-top: 4rem;
  min-height: calc(100vh - 107px);
    margin-left:auto;
  margin-right:auto;

}
main .inner-container {
  max-width: 800px;
  margin-left:auto;
  margin-right:auto;
}

table.invoice {
  background: #fff;
}
table.invoice .num {
  font-weight: 200;
  text-transform: uppercase;
  letter-spacing: 1.5px;
  font-size: .8em;
}
table.invoice tr, table.invoice td {
  background: #fff;
  text-align: left;
  font-weight: 400;
  color: #322d28;
}
table.invoice tr.header td img {
  max-width: 300px;
}
table.invoice tr.header td h2 {
  text-align: right;
  font-family: "Montserrat", sans-serif;
  font-weight: 200;
  font-size: 2rem;
  color: #1779ba;
}
table.invoice tr.intro td:nth-child(2) {
  text-align: right;
}
table.invoice tr.details > td {
  padding-top: 4rem;
  padding-bottom: 0;
}
table.invoice tr.details td.id, table.invoice tr.details td.qty, table.invoice tr.details th.id, table.invoice tr.details th.qty {
  text-align: center;
}
table.invoice tr.details td:last-child, table.invoice tr.details th:last-child {
  text-align: right;
}
table.invoice tr.details table thead, table.invoice tr.details table tbody {
  position: relative;
}
table.invoice tr.details table thead:after, table.invoice tr.details table tbody:after {
  content: '';
  height: 1px;
  position: absolute;
  width: 100%;
  left: 0;
  margin-top: -1px;
  background: #c8c3be;
}
table.invoice tr.totals td {
  padding-top: 0;
}
table.invoice tr.totals table tr td {
  padding-top: 0;
  padding-bottom: 0;
}
table.invoice tr.totals table tr td:nth-child(1) {
  font-weight: 500;
}
table.invoice tr.totals table tr td:nth-child(2) {
  text-align: right;
  font-weight: 200;
}
table.invoice tr.totals table tr:nth-last-child(2) td {
  padding-bottom: .5em;
}
table.invoice tr.totals table tr:nth-last-child(2) td:last-child {
  position: relative;
}
table.invoice tr.totals table tr:nth-last-child(2) td:last-child:after {
  content: '';
  height: 4px;
  width: 110%;
  border-top: 1px solid #1779ba;
  border-bottom: 1px solid #1779ba;
  position: relative;
  right: 0;
  bottom: -.575rem;
  display: block;
}
table.invoice tr.totals table tr.total td {
  font-size: 1.2em;
  padding-top: .5em;
  font-weight: 700;
}
table.invoice tr.totals table tr.total td:last-child {
  font-weight: 700;
}

.additional-info h5 {
  font-size: .8em;
  font-weight: 700;
  text-transform: uppercase;
  letter-spacing: 2px;
  color: #1779ba;
}

	</style>
	<title></title>
</head>
<body>
<c:choose>
			<c:when test="${role=='ROLE_ADMIN'}">
				<jsp:include page="navinvoice2.jsp" />
				<br>
				<br>
				<br>

			</c:when>
			<c:otherwise>
				<jsp:include page="navinvoice.jsp" />
				<br>
				<br>
				<br>

			</c:otherwise>
		</c:choose>
<header class="top-bar align-center">
</header>
<div class="row expanded">
  <main class="columns">
    <div class="inner-container">
    <section class="row">
      <div class="callout large invoice-container">
        <table class="invoice">
          <tr class="header">
            <td class="">
              Shree Shyam Textiles
            </td>
            <td class="align-right">
              <h2>Invoice</h2>
            </td>
          </tr>
          <tr class="intro">
            <td class="">
              Hello, ${cus.getFname()}.<br>
              Thank you for your order.
            </td>
            <td class="text-right">
            <c:forEach items="${allinv}" var="inv">
              <span class="num">Invoice # ${inv.getInv_id()}</span><br>
              ${inv.getDog()}
              </c:forEach>
            </td>
          </tr>
          <tr class="details">
            <td colspan="2">
              <table>
                <thead>
                  <tr>
                    <th class="id" style="width:200px">Item ID</th>
                    <th class="qty" style="width:200px">Quantity</th>
                    <th class="amt" style="width:200px">Price</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${allent}" var="invent">
                  <tr class="item">
                  
                    <td class="id num">${invent.getPid()}</td>
                    <td class="qty">${invent.getQuantity()}</td>
                    <td class="amt">${invent.getPrice()}</td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </td> 
          </tr>
          <tr class="totals">
            <td></td>
            <td>
              <table>
 				 <c:forEach items="${allinv}" var="inv">
                <tr class="total">
                	<td style="width:250px;"></td>
                  <td>Total</td>
                  <td>Rs. ${inv.getAmount()}</td>
                </tr>
                </c:forEach>
              </table>
            </td>
          </tr>
        </table>
        
        <section class="additional-info">
        <div class="row">
          <div class="columns">
            <h5>Billing Information</h5>
            <p>${cus.getFname()} ${cus.getMname()} ${cus.getLname()}<br>
              ${cus.getSno()}, ${cus.getStreetname()}<br>
              ${cus.getCity()} ${cus.getPin()}
           </p>
          </div>
        </div>
        </section>
      </div>
    </section>
    </div>
  </main>
</div>
</body>
</html>
