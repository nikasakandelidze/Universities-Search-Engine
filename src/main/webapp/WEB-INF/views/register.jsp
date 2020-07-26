<%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/26/2020
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    </style>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<div class="col-md-4 col-md-offset-4" id="register">
    <section id="inner-wrapper" class="register">
        <article>
            <p>
            <h1 style="text-align: center; font-family: Chandas">
                Registration Page
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="registerForm" action="/register" method="post" onsubmit="return validateInput()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="text" class="form-control" placeholder="Username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" class="form-control" placeholder="University Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" class="form-control" placeholder="Password" name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" class="form-control" placeholder="Confirm Password" name="confPassword">
                    </div>
                </div>
                <button type="submit" class="btn btn-success btn-block">Submit</button>
            </form>
        </article>
    </section>
</div>
</body>
</html>
<script>
    function validateInput(){
        var username = document.forms["registerForm"]["username"].value;
        var password = document.forms["registerForm"]["password"].value;
        var confPassword = document.forms["registerForm"]["confPassword"].value;
        var code = document.forms["registerForm"]["code"].value;
        var inputsNotEmpty = true
        if( username == "" ){
            inputsNotEmpty = false
            document.forms["registerForm"]["username"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["registerForm"]["username"].style.backgroundColor=""
        }
        if( password == "" ){
            inputsNotEmpty = false
            document.forms["registerForm"]["password"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["registerForm"]["username"].style.backgroundColor=""
        }
        var inputsNotEmpty = true
        if( confPassword == "" ){
            inputsNotEmpty = false
            document.forms["registerForm"]["confPassword"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["registerForm"]["confPassword"].style.backgroundColor=""
        }
        if( code == "" ){
            inputsNotEmpty = false
            document.forms["registerForm"]["code"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["registerForm"]["code"].style.backgroundColor=""
        }
        return inputsNotEmpty
    }
</script>
