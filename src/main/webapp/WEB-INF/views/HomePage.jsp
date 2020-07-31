<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 7/23/2020
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="styles/HomePage.css"%></style>
</head>
<body>
<%@include file="helpers/navbar.jsp"%>

<div>
    <h1 style=" text-align: center">Welcome to ProjectK</h1>
    <h4 style=" text-align: center; padding-top:30px; ">Get all the information about universities</h4>
</div>

<form  id="myForm" onsubmit="return getValue()" method="post" style="text-align: center; padding-top: 70px">
    <input type="text" placeholder="Search" id="searchData" aria-label="Search">
    <input type="submit" value="Search">
</form>
<div style=" padding-bottom: 70px;">
    <h3 style=" text-align: center">Faculties</h3>
</div>
<div class="row" style="padding-left: 200px; padding-bottom: 100px">
    <c:forEach items="${faculties}" var="faculty">
        <div class="list-group">
            <a href="/facultyListing/${faculty.category}" class="list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-between">
                    <h4>${faculty.category}</h4>
                </div>
            </a>
        </div>
    </c:forEach>
</div>
<div>
    <%@include file="helpers/footer.jsp"%>
</div>
</body>
</html>
<script>
   function getValue() {
       document.getElementById("myForm").action = "/homepage/search/"+document.getElementById("searchData").value;
        return true;
   }
</script>