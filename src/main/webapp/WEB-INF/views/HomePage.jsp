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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="styles/HomePage.css"%></style>
</head>
<body>
<%@include file="helpers/navbar.jsp"%>
<p>
<h1 style="text-align: center; color:cadetblue;">Welcome to ProjectK</h1>
<h4 style="text-align: center; padding-top:30px; color:cadetblue;">Get all the information about universities</h4>
</p>
<form action="/homepage/search" method="post" style="text-align: center; padding-top: 70px">
    <input type="text" placeholder="Search" name="searchData" aria-label="Search">
    <input type="submit" value="Search">
</form>
<h3 style=" text-align: center">Faculties</h3>
<div class="facultyList" style="padding-left: 100px; padding-bottom: 100px">
    <c:forEach items="${faculties}" var="faculty">
        <a href="/homepage/faculties/${faculty.category}">
                        <div class="facultyName" style="float:left; padding-left: 80px ">
                            <c:out value="${faculty.category}"></c:out>
                        </div>
        </a>
    </c:forEach>
</div>
<div>
    <%@include file="helpers/footer.jsp"%>
</div>
</body>
</html>
