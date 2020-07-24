
<%--
  Created by IntelliJ IDEA.
  User: nikasaka
  Date: 7/21/20
  Time: 10:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <p>
      <c:out value="${zoro}"></c:out>
        ${zoro}
    </p>
    <form action="/login" method="post">
        Username: <input type="text" name="username"><br><br>
        Password: <input type="password" name="password"><br><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>
