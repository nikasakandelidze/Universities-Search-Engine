<%--
  Created by IntelliJ IDEA.
  User: nikasaka
  Date: 7/21/20
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
Welcome <%=request.getParameter("username")%> + <%=request.getParameter("password")%>
</body>
</html>
