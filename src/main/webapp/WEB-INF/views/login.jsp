<%--
  Created by IntelliJ IDEA.
  User: nikasaka
  Date: 7/21/20
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 35%;
            height: 40px;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type=button], input[type=submit], input[type=reset] {
            background-color: #4CAF50;
            border: none;
            color: white;
            height: 50px;
            padding: 16px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }

        button:hover {
            opacity: 0.8;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/homepage">ProjectK</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/homepage">Home<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">about</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
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
<h1 style="text-align: center; color:cadetblue;">
    Login Page
</h1>
</p>
<p style="color:darkred; text-align: center">
    <c:out value="${errorMessage}"></c:out>

</p>
<form style="text-align: center" name="loginForm" action="/login" method="post" onsubmit="return validateInput()">
    Username: <input id="username" placeholder="Username" type="text" name="username"><br>
    Password: <input id="password" type="password" placeholder="Password" name="password"><br>
    <input type="submit" value="Login">
</form>
<p style="text-align: center; padding-top: 20px">
    Don't have an account?
    <a href="/register">
        Register now
    </a>
</p>
</body>
</html>


<script>
    function validateInput() {
        var username = document.forms["loginForm"]["username"].value;
        var password = document.forms["loginForm"]["password"].value;
        var errorMessage = "EmptyField"
        var inputsNotEmpty = true
        if (username == "") {
            inputsNotEmpty = false
            document.forms["loginForm"]["username"].style.backgroundColor = "rgba(255,69,0, 0.2)"
        } else {
            document.forms["loginForm"]["username"].style.backgroundColor = ""
        }
        if (password == "") {
            inputsNotEmpty = false
            document.forms["loginForm"]["password"].style.backgroundColor = "rgba(255,69,0, 0.2)"
        } else {
            document.forms["loginForm"]["username"].style.backgroundColor = ""
        }
        return inputsNotEmpty
    }
</script>
