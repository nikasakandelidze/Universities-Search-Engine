<%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 8/1/2020
  Time: 12:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Faculties</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style><%@include file="styles/universityListing.css"%></style>
</head>
<body>
<div class="faculty-list" style="float: left">
    <c:forEach items="${allFaculties}" var="faculty">
        <div class="list-group" style="height: 150px; width: 600px;">
            <a href="/faculty/${faculty.facultyId}" class="list-group-item list-group-item-action" style="border-radius: 10px;">
                <div class="fac-name">
                    Faculty name : ${faculty.name}
                </div>
                <div class="fac-name">
                    Faculty description : ${faculty.description}
                </div>
                <div class="fac-name">
                    Faculty price : ${faculty.price}
                </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>