
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
</head>
<body>
    <p>
        <h3>
            Login Page
        </h3>
    </p>
    <p style="color:darkred">
      <c:out value="${errorMessage}"></c:out>

    </p>
    <form name="loginForm" action="/login" method="post" onsubmit="return validateInput()" >
        Username: <input id="username" type="text" name="username"><h4 id="name_error" style="color:darkred"></h4><br><br>
        Password: <input id="password" type="password" name="password"><h4 id="pass_error" style="color:darkred"></h4><br>
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
            document.getElementById("name_error").innerText = errorMessage
            inputsNotEmpty = false
        }else{
            document.getElementById("name_error").innerText = ""
        }
        if( password == "" ){
            document.getElementById("pass_error").innerText = errorMessage
            inputsNotEmpty = false
        }else{
            document.getElementById("pass_error").innerText = ""
        }
        return inputsNotEmpty
    }
</script>
