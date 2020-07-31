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

<form action="/homepage/search" method="post" style="text-align: center; padding-top: 70px">

    <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Search Option</label>
    <select style="width: 200px;" class="custom-select my-1 mr-sm-2" id="inlineFormCustomSelectPref">
        <option selected>University Search</option>
        <option value="2">Faculty Search</option>
    </select>
    <input type="text" placeholder="Search" name="searchData" aria-label="Search">
    <input type="submit" value="Search">
</form>
<div style=" padding-bottom: 70px;">
    <h3 style=" text-align: center">Faculties</h3>
</div>
<div class="row" style="padding-left: 200px; padding-bottom: 100px">
    <c:forEach items="${faculties}" var="faculty">
        <div class="list-group">
            <a href="#" class="list-group-item list-group-item-action">
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
