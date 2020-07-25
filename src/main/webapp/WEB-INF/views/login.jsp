
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
    <style>
        /* Full-width inputs */
        input[type=text], input[type=password] {
            width: 35%;
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
    <p>
        <h1 style="text-align: center; font-family: Chandas">
            Login Page
        </h1>
    </p>
    <p style="color:darkred">
      <c:out value="${errorMessage}"></c:out>

    </p>
    <form style="text-align: center" name="loginForm" action="/login" method="post" onsubmit="return validateInput()" >
        Username: <input id="username" placeholder="Username" type="text" name="username"><br>
        Password: <input id="password" type="password" placeholder="Password" name="password"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>


<script>
    function validateInput(){
        var username = document.forms["loginForm"]["username"].value;
        var password = document.forms["loginForm"]["password"].value;
        var errorMessage = "EmptyField"
        var inputsNotEmpty = true
        if( username == "" ){
            inputsNotEmpty = false
            document.forms["loginForm"]["username"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["loginForm"]["username"].style.backgroundColor=""
        }
        if( password == "" ){
            inputsNotEmpty = false
            document.forms["loginForm"]["password"].style.backgroundColor="rgba(255,69,0, 0.2)"
        }else{
            document.forms["loginForm"]["username"].style.backgroundColor=""
        }
        return inputsNotEmpty
    }
</script>
