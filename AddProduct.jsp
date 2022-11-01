<%@page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" />
<html>
<head>
<title>Title</title>

</head>
<script>
    function validate()
    {
       var id = document.add.ProductId.value;
       var name = document.add.ProductName.value;
       var price = document.add.ProductPrice.value;
       var sdate = document.add.BidStartDate.value;
       var edate = document.add.BidEndDate.value;
       var date = new Date();
       if(id==null||id==""||id==0)
       {
          alert("ID can't be blank or zero")
          ;
          return false;
       }
       else if(name==null||name=="")
       {
          alert("Name can't be blank");
          return false;
       }
       else if(price==0||price=="")
       {
            alert("Price can't be blank or zero");
            return false;
       }
       else if(sdate>edate || sdate<date||edate<date)
       {
          alert("Invalid Bid Date");
          return false;
       }



    }
</script>
<body>
<div>
    <center><h1 style="font-family:Arial, Helvetica, sans-serif;margin-top:25px;">Product Adding Form</h1></center>
    <div align="center">
    <form:form name="add" action="ADD"   modelAttribute="bidactive" onSubmit="return validate()">
        <h4 style="font-family:Arial, Helvetica, sans-serif;margin-top:115px;">ProductId:<form:input path="ProductId" style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <h4 style="font-family:Arial, Helvetica, sans-serif;margin-top:10px;">ProductName:<form:input path="ProductName" style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <h4 style="font-family:Arial, Helvetica, sans-serif;margin-top:10px;">ProductPrice:<form:input path="ProductPrice" style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <h4 style="font-family:Arial, Helvetica, sans-serif;margin-top:10px;">StartDate:<form:input type="date"  path="BidStartDate" style="width:250px;height:35px;border:1px solid black;" /></h4><br/>
        <h4 style="font-family:Arial, Helvetica, sans-serif;margin-top:10px;">EndDate:<form:input type="date"  path="BidEndDate" style="width:250px;height:35px;border:1px solid black;"/></h4><br/>
        <form:hidden  path="BidAmount" value='0' style="width:250px;height:35px;border:1px solid black;"/><form:hidden  path="BidBy" value="Admin" style="width:250px;height:35px;border:1px solid black;"/>

        <input style="padding:4px;" type="submit" value="Submit">
    </form:form>
    </div>
</div>
</body>
</html>