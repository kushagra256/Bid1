<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" />

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center><h1 style="font-family:Arial, Helvetica, sans-serif;margin-top:25px;">WELCOME TO USER3</h1></center>
<h3>PRODUCT</h3>
<table style="width=100%;border:1px solid grey">
  <tr>
    <th style="border:1px solid grey;background:light grey;">ProductId</th>
    <th style="border:1px solid grey;background:light grey;">ProductName</th>
    <th style="border:1px solid grey;background:light grey;">ProductPrice</th>
    <th style="border:1px solid grey;background:light grey;">BidStartDate</th>
    <th style="border:1px solid grey;background:light grey;">BidEndDate</th>
    <th style="border:1px solid grey;background:light grey;">HighestBidAmount</th>
    <th style="border:1px solid grey;background:light grey;">BidBy</th>
  </tr>
 <c:forEach items="${bidactives}" var="product">

   <tr>
          <td><center>${product.getProductId()}</center></td>
          <td><center>${product.getProductName()}</center></td>
          <td><center>${product.getProductPrice()}</center></td>
          <td><center>${product.getBidStartDate()}</center></td>
          <td><center>${product.getBidEndDate()}</center></td>
          <td><center>${product.getBidAmount()}</center></td>
          <td><center>${product.getBidBy()}</center></td>
          <td><center><button style="color:white;background:grey;border:grey;"><a href="Bid?id=${product.getProductId()}&name=User3" style="text-decoration:none;color:white;">Bid</a></button></center></td>

   </tr>
   </c:forEach>

</table>
</body>
</html>