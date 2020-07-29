<%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/30/2020
  Time: 12:03 AM
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

<div class="uni-item">
    <c:forEach items="${allUniversities}" var="university">
        <p>
        <h1 style="text-align: center; color:cadetblue;">
            ${university.universityName}
        </h1>
        </p>
        <div class="list-group" style="height: 170px">
            <a class="list-group-item list-group-item-action" style="border-radius: 10px">
                <div class="uni-name">
                    <h4>${university.city}</h4>
                </div>
                <div class="uni-dean">
<%--                    <p id="demo">${university.}...</p>--%>
                </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>
