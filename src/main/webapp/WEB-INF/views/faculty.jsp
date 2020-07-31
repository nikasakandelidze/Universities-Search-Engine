<%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/29/2020
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Faculties</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="styles/facultyListing.css"%></style>
</head>
<body>
<%@include file="helpers/navbar.jsp"%>
<div class="faculty">
    <p>
    <h1 style="text-align: left; color:cadetblue;">
<%--        ${faculty.name}--%>
    Name
</h1>
    </p>
    <div class="list-group" style="float: left">
        <a class="list-group-item list-group-item-action" style="border-radius: 10px; width: 600px; height: 600px">
            <div class="fac-category">
                <h4>Category: ${faculty.category}</h4>
            </div>
            <div class="fac-price">
                <h4>Price: ${faculty.price}</h4>
            </div>
            <p>
            </p>
            <div class="fac-web">
                <h4>Faculty Link: ${faculty.webPageLink}</h4>
            </div>
            <div class="fac-desc">
                <h4>Faculty Description: ${faculty.description}</h4>
            </div>
            <div class="fac-dean">
                <h4>Faculty Dean: ${faculty.deanInfo}</h4>
            </div>
        </a>
    </div>
</div>
</p>
<h1 style="text-align: center; color:cadetblue;" >
    Subjects
</h1>
<div class="faculty-list" style="float: right; ">
    <%@include file="planeSubjectListing.jsp"%>
</div>
</body>
</html>

