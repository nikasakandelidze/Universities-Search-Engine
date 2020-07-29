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
    <title>Universities</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="styles/universityListing.css"%></style>
</head>
<body>
<p>
<h1 style="text-align: center; color:cadetblue;">
    Universities Page
</h1>
</p>
<div class="uni-list">
    <c:forEach items="${allUniversities}" var="university">
        <div class="list-group" style="height: 170px">
            <a href="/universityPage/${university.id}" class="list-group-item list-group-item-action" style="border-radius: 10px">
                <div class="uni-name">
                    <h4>${university.universityName}</h4>
                </div>
                <div class="uni-desc">
                    <p id="demo">${university.descriptions}...</p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>

