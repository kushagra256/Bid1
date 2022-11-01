<%@page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Update Form</title>
    <style>
        form input{
        margin-bottom:10px;
        }
    </style>

</head>
<body>
<center><h1 style="font-family:Arial, Helvetica, sans-serif;margin-top:25px;">Please Bid Below</h1></center>
<div align="center">
<center><h3 style="font-family:Arial, Helvetica, sans-serif;margin-top:25px;color:red">* Bid Value Must Be Greater Then the Product Price And Last Bid Price</h3></center>
    <form:form name="hi" action="bid-product" method="POST" modelAttribute="bid">
        ProductId:<form:input path="ProductId" style="width:250px;height:35px;border:1px solid black;" readonly="true"/></h4><br/>
        ProductName:<form:input  path="ProductName"  style="width:250px;height:35px;border:1px solid black;" readonly="true"/></h4><br/>
        ProductPrice:<form:input  path="ProductPrice"  style="width:250px;height:35px;border:1px solid black;" readonly="true"/></h4><br/>
        <form:hidden path="BidStartDate" style="width:250px;height:35px;border:1px solid black;" /></h4><br/>
        <form:hidden  path="BidEndDate" style="width:250px;height:35px;border:1px solid black;" /></h4><br/>
        Bid Amount:<form:input path="BidAmount"   style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <form:hidden path="BidBy"   style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <input type="submit" value="Submit">
    </form:form>
</div>

</body>
</html>