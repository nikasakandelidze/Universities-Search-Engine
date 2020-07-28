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
    <style><%@include file="styles/login.css"%></style>
</head>
<body>
<%@include file="helpers/navbar.jsp"%>
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
<script><%@include file="js/login.js"%></script>
