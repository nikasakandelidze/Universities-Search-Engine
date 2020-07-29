<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nikasaka
  Date: 7/21/20
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session = "true" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<%@include file="helpers/navbar.jsp"%>
<div style="text-align: center">
    <div style="color: darkred">
       <h1>${warningMessage}</h1>
    </div>
    <%@include file="helpers/profile.jsp"%>
</div>
<%@include file="helpers/footer.jsp"%>
</nav>
    Welcome <c:out  value="${sessionScope.user.getUserName()}"></c:out>

    <div class="todos">
        <a href="/adduniversity">
            <div style="border:1px solid black; float:left">
                <p>
                    Add University
                </p>
            </div>

        </a>
        <a href="/listuniversities/${user.getUsername()}">
            <div style="border:1px solid black; float:left">
                <p>
                    List Universities
                </p>
            </div>
        </a>
    </div>
<div class="todos">
    <a href="/addfaculty">
        <div style="border:1px solid black; float:left">
            <p>
                Add Faculty
            </p>
        </div>

    </a>
    <a href="/listenfaculties/${user.getUsername()}">
        <div style="border:1px solid black; float:left">
            <p>
                List Faculties
            </p>
        </div>
    </a>
</div>
<div class="todos">
    <a href="/addsubject">
        <div style="border:1px solid black; float:left">
            <p>
                Add Subject
            </p>
        </div>

    </a>
    <a href="/listensubjects/${user.getUsername()}">
        <div style="border:1px solid black; float:left">
            <p>
                List Subject
            </p>
        </div>
    </a>
</div>
</body>
</html>
