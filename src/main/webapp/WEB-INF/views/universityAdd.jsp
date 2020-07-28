<%@ page import="com.projectk.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: AzRy
  Date: 7/27/2020
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add University</title>
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
                University Registration
            </h1>
            </p>
            <p style="color:darkred">
                <c:out value="${errorMessage}"></c:out>
            </p>
            <form style="text-align: center" name="uniRegisterForm" action="/adduniversity" method="post" onsubmit="return validateRequiredFields()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="number" id="uniCode"class="form-control" placeholder="University Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" id="uniName"class="form-control" placeholder="University Name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="uniCity" class="form-control" placeholder="City" name="city">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="uniAddress" class="form-control" placeholder="Address" name="address">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="uniWeb" class="form-control" placeholder="Web Page" name="web">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="text" id="uniDescription" class="form-control" placeholder="Description" name="description">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="hidden" name="username" value="${sessionScope.user.username}" >
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
    function validateRequiredFields(){
        var code = document.getElementById("uniCode").value;
        var name = document.getElementById("uniName").value;
        var city = document.getElementById("uniCity").value;
        var address = document.getElementById("uniAddress").value;
        var web = document.getElementById("uniWeb").value;
        var description = document.getElementById("uniDescription").value;
        var inputsNotEmpty = true
        if( code == "" ){
            inputsNotEmpty = false
            document.getElementById("uniCode").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniCode").style.backgroundColor=""
        }
        if( name == "" ){
            inputsNotEmpty = false
            document.getElementById("uniName").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniName").style.backgroundColor=""
        }
        if( city == "" ){
            inputsNotEmpty = false
            document.getElementById("uniCity").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniCity").style.backgroundColor=""
        }
        if( address == "" ){
            inputsNotEmpty = false
            document.getElementById("uniAddress").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniAddress").style.backgroundColor=""
        }
        if( web == "" ){
            inputsNotEmpty = false
            document.getElementById("uniWeb").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniWeb").style.backgroundColor=""
        }
        if( description == "" ){
            inputsNotEmpty = false
            document.getElementById("uniDescription").style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.getElementById("uniDescription").style.backgroundColor=""
        }

        return inputsNotEmpty
    }
</script>
