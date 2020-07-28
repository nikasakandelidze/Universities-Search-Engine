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
    <style><%@include file="styles/register.css"%></style>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<%@include file="helpers/navbar.jsp"%>
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
            <form style="text-align: center" name="registerForm" action="/register" method="post"
                  onsubmit="return validate()">
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"> </i></span>
                        <input type="text" id="txtUsername" class="form-control" placeholder="Username" name="username">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-envelope"> </i></span>
                        <input type="text" id="txtCode" class="form-control" placeholder="University Code" name="code">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtPassword" class="form-control" placeholder="Password"
                               name="password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"> </i></span>
                        <input type="password" id="txtConfirmPassword" class="form-control"
                               placeholder="Confirm Password" name="confPassword">
                    </div>
                </div>
                <input type="submit" ></input>
            </form>
        </article>
    </section>
</div>
<%@include file="helpers/footer.jsp"%>
</body>
</html>
<script><%@include file="js/register.js"%></script>
