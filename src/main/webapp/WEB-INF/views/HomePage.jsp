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
    <title>Home Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style> input {
        width: 35%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    input:hover {
        border-color: #a0a0a0 #b9b9b9 #b9b9b9 #b9b9b9;
    }

    input:focus {
        border-color: #4d90fe;
    }

    input[type="submit"] {
        border-radius: 2px;
        background: #f2f2f2;
        border: 1px solid #f2f2f2;
        color: #757575;
        cursor: default;
        font-size: 14px;
        font-weight: bold;
        width: 100px;
        padding: 0 16px;
        height: 47px;
    }

    input[type="submit"]:hover {
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
        background: #f8f8f8;
        border: 1px solid #c6c6c6;
        box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
        color: #222;
    }
    .nav-item:hover {
        background-color: #cccccc;
    }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/homepage">ProjectK</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/homepage">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a  class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">about</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
    <p>
        <h1 style="text-align: center; color:cadetblue;">Welcome to ProjectK</h1>
        <h4 style="text-align: center; padding-top:30px; color:cadetblue;">Get all the information about universities</h4>
    </p>
    <form action="/homepage/search" method="post"  style="text-align: center; padding-top: 70px">
        <input  type="text" placeholder="Search" name="searchData" aria-label="Search">
        <input type="submit" value="Search">
    </form>
    <p style="color:darkred; text-align: center; padding-top: 50px">
        <h3 style=" text-align: center">Faculties</h3>
    <div class="facultyList" style="padding-left: 60px">
            <c:forEach items="${faculties}" var="faculty">
                <a href="/homepage/faculties/${faculty.category}" >
                     <span class="facultyClass border" style="float:left; padding-right: 80px; padding-left: 70px; background-color: #c6c6c6; border:1px solid black;">
                        <div  class="facultyName" style="float:left; padding-right: 80px; padding-left: 70px ">
                            <c:out value="${faculty.category}"></c:out>
                        </div>
                        <div class="facultyIcon">
                            <img width="200px" height="200px" src="https://cdn3.iconfinder.com/data/icons/digital-and-internet-marketing-2/132/72-512.png">
                        </div>
                    </span>
                </a>
            </c:forEach>
        </div>
    </p>
</body>
</html>
