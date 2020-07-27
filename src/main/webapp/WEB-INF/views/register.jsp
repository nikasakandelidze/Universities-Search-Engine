<%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/26/2020
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
    <style>
        body {
            background: #333;
        }

        #register {
            -webkit-perspective: 1000px;
            -moz-perspective: 1000px;
            perspective: 1000px;
            margin-top: 50px;
            margin-left: 30%;
        }

        .register .form-group {
            margin-bottom: 17px;
        }

        .register .form-control,
        .register .btn {
            border-radius: 0;
        }

        .register .btn {
            text-transform: uppercase;
            letter-spacing: 3px;
        }

        .input-group-addon {
            border-radius: 0;
            color: #fff;
            background: #f3aa0c;
            border: #f3aa0c;
        }

        .forgot a {
            color: #333;
        }

        .forgot a:hover {
            color: #5cb85c;
        }
         input[type=submit] {
            background-color: #4CAF50;
            border: none;
            color: white;
            width: 150px;
            height: 50px;
            padding: 16px 32px;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
<div class="col-md-4 col-md-offset-4" id="register">
    <section id="inner-wrapper" class="register">
        <article>
            <p>
            <h1 style="text-align: center; color:cadetblue;">
                Registration Page
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="registerForm" action="/register" method="post" onsubmit="return validate()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="text" id="txtUsername"class="form-control" placeholder="Username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" id="txtCode"class="form-control" placeholder="University Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtPassword" class="form-control" placeholder="Password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtConfirmPassword" class="form-control" placeholder="Confirm Password" name="confPassword">
                    </div>
                </div>
                <input type="submit" ></input>
            </form>
        </article>
    </section>
</div>
</body>
</html>
<script>
    function validate() {
        return validatePassword() && validateRequiredFields();
    }

    function validateRequiredFields(){
        var username = document.getElementById("txtUsername").value;
        var password = document.getElementById("txtPassword").value;
        var confPassword = document.getElementById("txtConfirmPassword").value;
        var code = document.getElementById("txtCode").value;
        var inputsNotEmpty = true
        if( username == "" ){
            inputsNotEmpty = false
            document.getElementById("txtUsername").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("txtUsername").style.backgroundColor=""
        }
        if( password == "" ){
            inputsNotEmpty = false
            document.getElementById("txtPassword").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("txtPassword").style.backgroundColor=""
        }
        if( confPassword == "" ){
            inputsNotEmpty = false
            document.getElementById("txtConfirmPassword").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("txtConfirmPassword").style.backgroundColor=""
        }
        if( code == "" ){
            inputsNotEmpty = false
            document.getElementById("txtCode").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("txtCode").style.backgroundColor=""
        }
        return inputsNotEmpty
    }

    function validatePassword() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            window.alert("Passwords do not match.");
            return false;
        }
        return true;
    }

</script>
