<%--
  Created by IntelliJ IDEA.
  User: basa
  Date: 7/30/2020
  Time: 9:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculties</title>
</head>
<body>
<div class="faculty-list" style="float: left">
    <c:forEach items="${allFaculties}" var="faculty">
        <div class="list-group" style="height: 170px; width: 150px;">
            <a href="/faculty/${faculty.facultyId}" class="list-group-item list-group-item-action" style="border-radius: 10px">
                <div class="faculty-name">
                    <h4>${faculty.name}</h4>
                </div>
                <div class="uni-desc">
                    <p id="demo">${faculty.description}...</p>
                </div>
            </a>
        </div>
    </c:forEach>
</div>
</body>
</html>
